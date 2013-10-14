/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.weakref.puzzlers;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class UnsynchronizedSet
{
    public static void main(String[] args)
            throws InterruptedException
    {
        final Set<Integer> set = new HashSet<>();

        Thread thread1 = new Thread(newTask("a", set));
        Thread thread2 = new Thread(newTask("b", set));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Done");
    }

    private static Runnable newTask(final String name, final Set<Integer> set)
    {
        return new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 10_000_000; ++i) {
                        if (i % 100_000 == 0) {
                            System.out.println(name + ": " + i);
                        }
                        set.remove(ThreadLocalRandom.current().nextInt(1_000_000));
                        set.add(ThreadLocalRandom.current().nextInt(1_000_000));
                        Thread.yield();
                    }
                }
            };
    }
}
