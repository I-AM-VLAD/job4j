package ru.job4j.chapter_005.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;
    private List<E> isBinary = new ArrayList<>();
    Tree(final E root) {
        this.root = new Node<>(root);
        isBinary.add(root);
    }
    @Override
    public boolean isBinary() {
        boolean rsl = false;
        for(E el : isBinary) {
            if(findBy(el).get().children.size() > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> opChild = findBy(child);
        Optional<Node<E>> opParent = findBy(parent);
        if(!opChild.isEmpty() || opParent.isEmpty()) {return false;}
        Node<E> nodeChild = new Node<>(child);
        Node<E> nodeParent = opParent.get();
        nodeParent.children.add(nodeChild);
        isBinary.add(child);
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}

