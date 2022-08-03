package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.entity.Chart;
import ru.x3m.rem.repository.ChartRepo;

import java.util.List;

@Service
@Transactional
public class ChartService {

    private final ChartRepo chartRepo;

    @Autowired
    public ChartService(ChartRepo chartRepo) {
        this.chartRepo = chartRepo;
    }

    public List<Chart> findAllCharts() {
        return (List<Chart>) chartRepo.findAll();
    }

    public Chart findChartById(Long id) {
        return chartRepo.findChartByTestId(id);
    }

}
