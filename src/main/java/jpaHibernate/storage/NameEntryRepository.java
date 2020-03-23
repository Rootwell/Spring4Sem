package jpaHibernate.storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jpaHibernate.model.NameEntry;

@Repository
public interface NameEntryRepository extends CrudRepository<NameEntry, Long> {
}
