$(document).ready(function () {
    console.log('test');
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
            console.log(data)
            data.body.data.list.forEach((a, i) => {
                console.log(a.tentNm);
                console.log(i);
                const link = $('<a>');
                link.text(a.tentNm);
                link.on('click', function () {
                    console.log('test');
                    details(a);
                })

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
    $('#tent-title').text(tent.tentNm);
    $('#modal').modal('show');
}