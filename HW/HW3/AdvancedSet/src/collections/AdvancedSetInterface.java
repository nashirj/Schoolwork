package collections;

public interface AdvancedSetInterface<T> extends CollectionInterface<T> {
	AdvancedSetInterface<T> union(AdvancedSetInterface<T> other);
	AdvancedSetInterface<T> intersection(AdvancedSetInterface<T> other);
	AdvancedSetInterface<T> difference(AdvancedSetInterface<T> other);
}
