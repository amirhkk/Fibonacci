/*
 * Copyright 2021 Andrew Rice <acr31@cam.ac.uk>, Amir Kadkhodaei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ahk44.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class FibonacciTableTest {

  @Test
  public void fib_makesUseOfCache() {
    // ARRANGE
    CountingMap countingmap = new CountingMap();
    FibonacciTable fibonacci = new FibonacciTable();
    FibonacciTable fibonacci2 = new FibonacciTable(countingmap);

    // ACT
    int result = fibonacci.fib(20);
    int result2 = fibonacci2.fib(20);
    int cnt = countingmap.getCounter();

    // ASSERT
    assertThat(result).isEqualTo(6765);
    assertThat(result2).isEqualTo(6765);
    assertThat(cnt).isGreaterThan(0);


    // Hint: use CountingMap!
  }
}
