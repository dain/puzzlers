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

import java.util.ArrayList;
import java.util.List;

public class ImmutableObjects
{
    private static class Immutable1
    {
        public final int value = 1;
    }

    private static class Immutable2
    {
        private final List<Integer> values = new ArrayList<>();

        private Immutable2()
        {
            values.add(1);
            values.add(2);
        }

        public int get(int index)
        {
            return values.get(index);
        }
    }

    private static class Mutable
    {
        public final int x = 1;
        public int y = 2;
    }
}
