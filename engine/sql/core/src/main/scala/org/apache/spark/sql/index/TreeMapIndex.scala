/*
 *  Copyright 2016 by Simba Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.spark.sql.index

import org.apache.spark.sql.Row

/**
 * Created by dong on 6/1/15.
 */

class TreeMapIndex[T] extends Index {
  var index = new java.util.TreeMap[T, Int]()
}

object TreeMapIndex {
  def apply[T](data: Array[(T, Row)]) = {
    val ans = new TreeMapIndex[T]
    for (i <- data.indices) {
      ans.index.put(data(i)._1, i)
    }
    ans
  }
}
