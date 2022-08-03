$(document).ready(function () {

    $.getJSON('/rem/statistic/api/finAllOutlays', function (data) {
        const
            categoriesJ = [],
            nameJ = [],
            dataJ = [];

        $.each(data, function (i, el) {
            categoriesJ.push(el.itemName);
            dataJ.push(parseFloat(el.price));
            nameJ.push(el.subitemName);
        });
        console.log(categoriesJ)
        console.log(dataJ)
        console.log(nameJ)

        options.series[0].data = dataJ;
        options.series[0].name = nameJ;
        const chart = new Highcharts.Chart(options);

        Highcharts.chart('container', {

            chart: {
                type: 'column'
            },
            title: {
                text: 'Stacked column chart'
            },
            xAxis: {
                categories: categoriesJ
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Total fruit consumption'
                },
                stackLabels: {
                    enabled: true,
                    style: {
                        fontWeight: 'bold',
                        color: ( // theme
                            Highcharts.defaultOptions.title.style &&
                            Highcharts.defaultOptions.title.style.color
                        ) || 'gray',
                        textOutline: 'none'
                    }
                }
            },
            legend: {
                align: 'right',
                x: -30,
                verticalAlign: 'top',
                y: 25,
                floating: true,
                backgroundColor:
                    Highcharts.defaultOptions.legend.backgroundColor || 'white',
                borderColor: '#CCC',
                borderWidth: 1,
                shadow: false
            },
            tooltip: {
                headerFormat: '<b>{point.x}</b><br/>',
                pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            series: []
        });

        // options.xAxis.categories = categoriesJ;


    });


});

