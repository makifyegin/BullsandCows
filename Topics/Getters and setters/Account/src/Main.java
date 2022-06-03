class Account {

    private long balance;
    private String ownerName;
    private boolean locked;

    public String getOwnerName() {
        return ownerName;
    }

    public boolean isLocked() {
        return locked;
    }


    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }


    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}