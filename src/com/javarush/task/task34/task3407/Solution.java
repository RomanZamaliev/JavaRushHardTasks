package com.javarush.task.task34.task3407;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/* 
Призрачные ссылки
*/

public class Solution {
    public static Helper helper = new Helper();

    public static class Monkey{
        public String name;
        Monkey(String name){
            this.name = name;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        helper.startTime();
        List<PhantomReference<Monkey>> list = helper.getPopulatedList();

        //before GC
        helper.checkListWithReferences(list, "before");

        helper.callGC();
        helper.consumeHeap();

        //after GC
        helper.checkListWithReferences(list, "after");

        helper.finish();
    }

    public static class Helper {
        private ReferenceQueue<Monkey> queue = new ReferenceQueue<>();

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        public ReferenceQueue<Monkey> getQueue() {
            return queue;
        }

        void consumeHeap() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (true) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void checkListWithReferences(List<PhantomReference<Monkey>> list, String string) {
            int count = 0;
            for (PhantomReference<Monkey> reference : list) {
                if (reference.isEnqueued()) {
                    count++;
                }
            }

            System.out.println(String.format("The count of enqueued references is %d (%s GC was called)", count, string));
        }

        public List<PhantomReference<Monkey>> getPopulatedList() {
            List<PhantomReference<Monkey>> list = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                list.add(new PhantomReference<>(new Monkey("Monkey-" + i), helper.getQueue()));
            }
            return list;
        }

        public void finish() throws InterruptedException {
            int count = 0;
            PhantomReference<Monkey> reference;
            while ((reference = (PhantomReference<Monkey>) queue.poll()) != null) {
                count++;
                System.out.println(reference.get().name);
            }
            System.out.println(count + " objects are in the phantom reference queue");
            System.out.println("It took " + getTime() + " s");
        }
    }
}
