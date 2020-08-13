/*
 * Copyright (c) 2020, Board of Trustees of the University of Iowa
 * All rights reserved.
 *
 * Licensed under the BSD 3-Clause License. See LICENSE in the project root for license information.
 */

package edu.uiowa.kind2.lustre;

/**
 * This abstract class represents the items (i.e., statements) that can appear in a contract body.
 */
public abstract class ContractItem extends Ast {
  /**
   * Constructor
   *
   * @param location location of contract item in a Lustre file
   */
  public ContractItem(Location location) {
    super(location);
  }
}
