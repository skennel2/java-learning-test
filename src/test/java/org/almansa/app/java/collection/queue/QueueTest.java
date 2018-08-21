package org.almansa.app.java.collection.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

public class QueueTest {
        
    @Test
    public void BlockingQueue인터페이스의_구현체종류() {
        // Queue가 꽉찼을때의 삽입 시도, Queue가 비어있을때의 추출 시도를 막아주는 thread-safe한 Queue의 한 부류이다.

        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        assertEquals(true, arrayBlockingQueue instanceof BlockingQueue);
        assertEquals(true, linkedBlockingQueue instanceof BlockingQueue);
        assertEquals(true, priorityBlockingQueue instanceof BlockingQueue);
        assertEquals(true, synchronousQueue instanceof BlockingQueue);
    }
    
    @Test
    public void Queue의_기본적인_사용법() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("yellow"); 
        queue.offer("white");
        queue.offer("red");
        
        assertEquals(3, queue.size()); 
        
        String poll1 = queue.poll();
        
        assertEquals("yellow", poll1);
        assertEquals(2, queue.size()); 
    }
}
