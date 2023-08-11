var map = null;
$(document).ready(function () {
    search(null, 0, 10);
})

function search (name, page, size) {
    const tbody = $('#tent-table-body');
    tbody.empty();
    $.ajax({
        url: '/api/tents',
        type: 'GET',
        dataType: 'json',
        data: {
            name: name,
            page: page,
            size: size
        },
        success: function (data, textStatus, xhr) {
            data.body.data.list.forEach((a, i) => {
                console.log(data);
                const link = $('<a>');
                link.text(a.tentNm);
                link.attr('href', '/tents/' + a.tentId)
                const td = $('<td>');
                td.append(link);

                const tr = $('<tr>')
                tr.append(td);

                tbody.append(tr);
            })
            const pageList = $('#pagination');
            pageList.empty();
            if(data.body.totalCount < 10) {
                return;
            }

            let totalPage = Math.ceil(data.body.totalCount / 10);
            let pageGroup = Math.ceil(data.body.startPage / 10);

            let last = pageGroup * 10;
            if(last > totalPage) {
                last = totalPage;
            }
            let first = last - (10 - 1) <= 0 ? 1 : last - (10 - 1);
            let next = last + 1;
            let prev = first - 1;

            if(prev > 0) {
                const li = $("<li>");
                const a = $("<a>");
                a.text('Previous');
                a.addClass('page-link')
                li.append(a);

                li.addClass('page-item');
                pageList.append(li);
            }
            for(let i = first; i <= last; i++) {
                const li = $("<li>");
                const a = $("<a>");
                a.text(i);
                a.addClass('page-link')
                a.on('click', function () {
                    search(name, i, size);
                })
                li.append(a);

                li.addClass('page-item');
                pageList.append(li);
            }

            if(last < totalPage) {
                const li = $("<li>");
                const a = $("<a>");
                a.text('Next');
                a.addClass('page-link')
                li.append(a);

                li.addClass('page-item');
                pageList.append(li);
            }
        }
    })}

function details(tent) {

    $.ajax({
        url: "/api/tents/" + tent.tentId,
        type: 'get',
        dataType: 'json',
        success: function (data, textStatus, xhr) {
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
            $('#tent-title').text(tent.tentNm);
            $('#tent-addr').text(tent.tentAddr)
            if(tent.tentHomepage !== '') {
                $('#tent-homepage').html(tent.tentHomepage);
            } else {
                $('#tent-homepage').text('없음');
            }
            $('#tent-intro').html(tent.tentIntro);
            $('#tent-open').html(tent.tentOpen);
            $('#tent-traffic-info').html(tent.tentTrafficInfo);
            $('#tent-reservation').text(tent.tentReservation);
            $('#modal').modal('show');
}