//
// Generated by JTB 1.3.2
//

package org.andwellness.config.grammar.syntaxtree;

/**
 * Grammar production:
 * f0 -> "=="
 *       | "!="
 *       | "<"
 *       | ">"
 *       | "<="
 *       | ">="
 */
public class condition implements Node {
   public NodeChoice f0;

   public condition(NodeChoice n0) {
      f0 = n0;
   }

   public void accept(org.andwellness.config.grammar.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(org.andwellness.config.grammar.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(org.andwellness.config.grammar.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(org.andwellness.config.grammar.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

