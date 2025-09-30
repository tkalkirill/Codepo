package org.codepo.experience.others.pyatkov;

import java.util.Stack;

/**
 * Задача: создать очередь используя только стек.
 * <p>
 * Решение: использовать два стека. Первый стек для добавления элементов, второй для удалоения.
 */
class VtbQueueOnStack {
    static class Queue<T> {
        private final Stack<T> stackToAdd = new Stack<>();

        private final Stack<T> stackToPoll = new Stack<>();

        void add(T t) {
            stackToAdd.add(t);
        }

        T poll() {
            updateStackToPollIfNeeded();

            return stackToPoll.isEmpty() ? null : stackToPoll.pop();
        }

        int size() {
            return stackToAdd.size() + stackToPoll.size();
        }

        private void updateStackToPollIfNeeded() {
            if (!stackToPoll.isEmpty()) {
                return;
            }

            while (!stackToAdd.isEmpty()) {
                stackToPoll.add(stackToAdd.pop());
            }
        }
    }
}
