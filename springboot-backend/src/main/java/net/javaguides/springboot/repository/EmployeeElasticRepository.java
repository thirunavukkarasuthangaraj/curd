package net.javaguides.springboot.repository;

 
import net.javaguides.springboot.model.Employees;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeElasticRepository extends ElasticsearchRepository<Employees, Long> {
}
