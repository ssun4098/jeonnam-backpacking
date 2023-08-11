$(document).ready(function () {
    const urlParams = new URL(location.href).searchParams;
    console.log(urlParams.get("tentNm"));
    get(urlParams.get("tentNm"));
    function get(tentNm) {
        $.ajax({
            url: '/api/tents',
            type: 'GET',
            dataType: 'json',
            data: {
                name: tentNm
            },
            success: function(tent) {
                console.log(tent);
                // $('#tent-title').text(tent.tentNm);
                // $('#tent-addr').text(tent.tentAddr)
                // $('#tent-intro').html(tent.tentIntro);
                // $('#tent-open').html(tent.tentOpen);
                // $('#tent-traffic-info').html(tent.tentTrafficInfo);
                // $('#tent-reservation').text(tent.tentReservation);
            },
            error: function (data) {

            }
        })
    }
    function getImg(id) {
        $.ajax({
            url: "/api/tents/" + id,
            type: 'get',
            dataType: 'json',
            success: function (data) {
                const imgArea = $('#img-area')
                for(let i = 0; i < data.body.data.list.length; i++) {
                    const img = $('<img>').attr('src', data.body.data.list[i].imgUrl);
                    imgArea.append(img);
                }
                $('img').addClass('rounded ms-1 mt-1').width(400).height(250);
            },
            error: function(error) {
                console.log(error);
            }
        })
    }
})