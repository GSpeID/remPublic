document.addEventListener('DOMContentLoaded', function () {
    const chart = Highcharts.chart('container', {
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Будут несколько поддобных графиков, пока дэмо для красоты'
        },
        xAxis: {
            categories: ['Закупки', 'Расходники', 'Инструменты', 'Обслуживание транспорта']
        },
        yAxis: {
            title: {
                text: 'Потрачено средств'
            }
        },
        series: [{
            name: 'Апрель',
            data: [11256, 56786, 13264, 75253]
        }, {
            name: 'Май',
            data: [45345, 89078, 33765, 34951]
        }, {
            name: 'Июнь',
            data: [7562, 74633, 16358, 105688]
        }, {
            name: 'Июль',
            data: [75322, 41025, 34222, 76522]
        }, {
            name: 'Август',
            data: [12577, 65333, 64123, 21000]
        }]
    });
});