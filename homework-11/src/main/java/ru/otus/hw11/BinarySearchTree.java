package ru.otus.hw11;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements SearchTree<T> {

    private Node<T> root;
    private List<T> sortedList;

    // Внутренний класс узла дерева
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Конструктор: строит дерево из отсортированного списка
    public BinarySearchTree(List<T> sortedList) {
        this.sortedList = sortedList;
        this.root = buildTree(sortedList, 0, sortedList.size() - 1);
    }

    // Рекурсивное построение сбалансированного дерева
    private Node<T> buildTree(List<T> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node<T> node = new Node<>(list.get(mid));

        node.left = buildTree(list, start, mid - 1);
        node.right = buildTree(list, mid + 1, end);

        return node;
    }

    // Рекурсивный поиск элемента
    @Override
    public T find(T element) {
        return findRecursive(root, element);
    }

    private T findRecursive(Node<T> node, T element) {
        if (node == null) {
            return null;
        }

        int comparison = element.compareTo(node.value);

        if (comparison == 0) {
            return node.value;
        } else if (comparison < 0) {
            return findRecursive(node.left, element);
        } else {
            return findRecursive(node.right, element);
        }
    }

    // Возврат отсортированного списка (in-order traversal)
    @Override
    public List<T> getSortedList() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, result);
        result.add(node.value);
        inOrderTraversal(node.right, result);
    }
}
