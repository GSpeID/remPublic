package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.Chart;

@Repository
public interface ChartRepo extends CrudRepository<Chart, Long> {

    Chart findChartByTestId(Long testId);

}
