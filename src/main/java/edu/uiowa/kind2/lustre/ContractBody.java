/*
 * Copyright (c) 2020, Board of Trustees of the University of Iowa
 * All rights reserved.
 *
 * Licensed under the BSD 3-Clause License. See LICENSE in the project root for license information.
 */

package edu.uiowa.kind2.lustre;

import java.util.List;

import edu.uiowa.kind2.Assert;
import edu.uiowa.kind2.util.Util;

/**
 * This class represents a contract body which can be embedded in a node's inline contract or an
 * external contract node. The body is composed of items, each of which define
 * <ul>
 * <li>a ghost variable / constant,</li>
 * <li>an assumption,</li>
 * <li>a guarantee,</li>
 * <li>a mode, or</li>
 * <li>an import of a contract node.</li>
 * </ul>
 */
public class ContractBody extends Ast {
  /**
   * A list of contract items. Order matters, so we must use one list for all items.
   */
  public final List<ContractItem> items;

  /**
   * Constructor
   *
   * @param location location of contract body in a Lustre file
   * @param items    a list of contract items
   */
  public ContractBody(Location location, List<ContractItem> items) {
    super(location);
    Assert.isFalse(items.isEmpty()); // contract body must contain at least one item
    this.items = Util.safeList(items);
  }

  /**
   * Constructor
   *
   * @param items a list of contract items
   */
  public ContractBody(List<ContractItem> items) {
    this(Location.NULL, items);
  }
}
