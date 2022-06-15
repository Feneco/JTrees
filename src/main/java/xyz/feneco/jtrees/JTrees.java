package xyz.feneco.jtrees;

import java.util.ArrayList;

public class JTrees<T> {
    private T data;
    private JTrees<T> parent;
    private ArrayList<JTrees<T>> children;

    public JTrees(T data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<JTrees<T>>();
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public int getLevel() {
        if (this.isRoot())
            return 0;
        else
            return parent.getLevel() + 1;
    }

    public JTrees<T> addChild(JTrees<T> child) {
        child.parent = this;
        this.children.add(child);
        return child;
    }

    public JTrees<T> addChild(T child) {
        JTrees<T> childNode = new JTrees<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public JTrees<T> getParent() {
        return this.parent;
    }

    public void setParent(JTrees<T> newParent) {
        this.parent = newParent;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T newData) {
        this.data = newData;
    }

    public JTrees<T> getChildren(int index) {
        return this.children.get(index);
    }

    @Override
    public String toString() {
        if(data != null){
            return data.toString();
        }
        return "null";
    }

    public Object[] toArray() {
        return this.children.toArray();
    }
}