package vistra.test.energy.utils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

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
	
	public static Specification<Unit> startDate(Date expression) {
	    return (root, query, builder) -> builder.greaterThanOrEqualTo(root.<Date>get("unitStartDate"), expression);
	}
	
	public static Specification<Unit> endDate(Date expression) {
	    return (root, query, builder) -> builder.lessThanOrEqualTo(root.<Date>get("unitEndDate"), expression);
	}
	
	public static Specification<Unit> unitTypeId(Long expression) {
	    return (root, query, builder) -> builder.equal(root.get("unitTypeId"), expression);
	}
	
	public static Specification<Unit> unitIdList(List<Long> expression) {
	    return (root, query, builder) -> root.get("id").in(expression);
	}
	
	private static String contains(String expression) {
	    return MessageFormat.format("%{0}%", expression);
	}
}
