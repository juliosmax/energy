package vistra.test.energy.utils;

import java.text.MessageFormat;

import org.springframework.data.jpa.domain.Specification;

import vistra.test.energy.model.Unit;

public final class UnitSpecification {
	public static Specification<Unit> nameContains(String expression) {
	    return (root, query, builder) -> builder.like(root.get("name"), contains(expression));
	}
	
	public static Specification<Unit> draftEq(Boolean expression) {
	    return (root, query, builder) -> builder.equal(root.get("draft"), expression);
	}
	
	public static Specification<Unit> unitIdentifierEq(String expression) {
	    return (root, query, builder) -> builder.equal(root.get("unitIdentifier"), expression);
	}
	
	private static String contains(String expression) {
	    return MessageFormat.format("%{0}%", expression);
	}
}
