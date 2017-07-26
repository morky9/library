package model;

public class Name {
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;

        // TODO: if not uniqe throw expetions. need to hold all names
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String fullNamr(){
        return first+" "+last;
    }
}
