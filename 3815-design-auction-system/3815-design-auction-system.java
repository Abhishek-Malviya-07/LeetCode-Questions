class AuctionSystem {
    class Bid {
        int id;
        int amt;
        Bid(int id, int amt) {
            this.id = id;
            this.amt = amt;
        }
    }
    
    private Map<Integer, Map<Integer, Integer>> map1;
    private Map<Integer, TreeSet<Bid>> map2;
    
    public AuctionSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void addBid(int uid, int iid, int amt) {
        if (!map1.containsKey(iid)) {
            map1.put(iid, new HashMap<>());
            map2.put(iid, new TreeSet<>((a, b) -> {
                if (a.amt != b.amt) return b.amt - a.amt;
                return b.id - a.id;
            }));
        }
        
        Map<Integer, Integer> map3 = map1.get(iid);
        TreeSet<Bid> map4 = map2.get(iid);
        
        if (map3.containsKey(uid)) {
            int old = map3.get(uid);
            map4.remove(new Bid(uid, old));
        }
        
        map3.put(uid, amt);
        map4.add(new Bid(uid, amt));
    }
    
    public void updateBid(int uid, int iid, int amt) {
        addBid(uid, iid, amt);
    }
    
    public void removeBid(int uid, int iid) {
        if (map1.containsKey(iid)) {
            Map<Integer, Integer> map3 = map1.get(iid);
            TreeSet<Bid> map4 = map2.get(iid);
            
            if (map3.containsKey(uid)) {
                int amt = map3.remove(uid);
                map4.remove(new Bid(uid, amt));
            }
        }
    }
    
    public int getHighestBidder(int iid) {
        TreeSet<Bid> map4 = map2.get(iid);
        if (map4 == null || map4.isEmpty()) return -1;
        return map4.first().id;
    }
}
