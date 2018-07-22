package ru.mibix.im.parser.model;

/**
 * Created by ser on 05.01.2016.
 */
public abstract class AbstractModel {

    private static final long serialVersionUID = 1L;

    private int id;

    public AbstractModel() { }

    public AbstractModel(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}