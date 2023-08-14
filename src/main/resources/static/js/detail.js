$(document).ready(function () {
    const urlParams = new URL(location.href).searchParams;
    console.log(urlParams.get("name"));
    get(urlParams.get("name"));
    function get(tentNm) {
        $.ajax({
            url: '/api/tents',
            type: 'GET',
            dataType: 'json',
            data: {
                name: encodeURI(tentNm)
            },
            success: function(tent) {
                console.log(tent.body.data.list);
                $('#tent-title').text(tent.body.data.list.tentNm);
                $('#tent-addr').text(tent.body.data.list.tentAddr)
                $('#tent-intro').html(tent.body.data.list.tentIntro);
                $('#tent-open').html(tent.body.data.list.tentOpen);
                $('#tent-traffic-info').html(tent.body.data.list.tentTrafficInfo);
                $('#tent-reservation').text(tent.body.data.list.tentReservation);
                getImg(tent.body.data.list.tentId);
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