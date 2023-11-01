package menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import menu.bean.Order;

@Repository
public interface MenuRepository extends JpaRepository<Order, Long>{

}
