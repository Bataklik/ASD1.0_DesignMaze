package repository;

import java.util.List;

import domein.Reductiebon;

public interface ReductieBonDao {
	List<Reductiebon> findAll();
}
