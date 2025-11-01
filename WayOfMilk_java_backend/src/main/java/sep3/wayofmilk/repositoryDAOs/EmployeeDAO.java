package sep3.wayofmilk.repositoryDAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sep3.wayofmilk.entities.Employee;

@Repository public interface EmployeeDAO extends JpaRepository<Employee, Long>
{
}
