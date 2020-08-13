/*
 * Copyright (c) 2012-2013, Rockwell Collins
 * All rights reserved.
 *
 * Licensed under the BSD 3-Clause License. See LICENSE in the project root for license information.
 */

package edu.uiowa.kind2.lustre.values;

import edu.uiowa.kind2.lustre.BinaryOp;
import edu.uiowa.kind2.lustre.UnaryOp;

public class UnknownValue extends Value {

  public static final Value UNKNOWN = new UnknownValue();

  @Override
  public Value applyBinaryOp(BinaryOp op, Value right) {
    switch (op) {
      case PLUS:
      case MINUS:
      case MULTIPLY:
      case DIVIDE:
      case INT_DIVIDE:
      case MODULUS:
      case EQUAL:
      case NOTEQUAL:
      case GREATER:
      case LESS:
      case GREATEREQUAL:
      case LESSEQUAL:
      case XOR:
      case IMPLIES:
        return UNKNOWN;

      case OR:
        if (right instanceof BooleanValue) {
          BooleanValue v = (BooleanValue) right;
          if (v.value) {
            return BooleanValue.TRUE;
          }
        }
        return UNKNOWN;

      case AND:
        if (right instanceof BooleanValue) {
          BooleanValue v = (BooleanValue) right;
          if (!v.value) {
            return BooleanValue.FALSE;
          }
        }
        return UNKNOWN;

      case ARROW:
      default:
        return null;
    }
  }

  @Override
  public Value applyUnaryOp(UnaryOp op) {
    switch (op) {
      case NEGATIVE:
      case NOT:
        return UNKNOWN;

      default:
        return null;
    }

  }

  @Override
  public String toString() {
    return "?";
  }
}
