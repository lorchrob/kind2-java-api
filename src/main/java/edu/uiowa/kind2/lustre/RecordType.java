/*
 * Copyright (c) 2012-2013, Rockwell Collins
 * All rights reserved.
 *
 * Licensed under the BSD 3-Clause License. See LICENSE in the project root for license information.
 */

package edu.uiowa.kind2.lustre;

import java.util.Map;
import java.util.SortedMap;

import edu.uiowa.kind2.Assert;
import edu.uiowa.kind2.util.Util;

class RecordType extends Type {
  final String id;
  final SortedMap<String, Type> fields;

  RecordType(String id, Map<String, Type> fields) {
    Assert.isNotNull(id);
    Assert.isNotNull(fields);
    Assert.isTrue(fields.size() > 0);
    this.id = id;
    this.fields = Util.safeStringSortedMap(fields);
  }
}
