//const dataSource = {
//    withCredentials: false,
//    initialRequest: true,
//    api: {
//        readData: { url: '/board/data', method: 'GET' },
//        CreateData: { url: '/board/data', method: 'POST' },
//        updateData: { url: '/board/data', method: 'PUT' },
//        deleteData: { url: '/board/data', method: 'DELETE' }
//    }
//};

const grid = new tui.Grid({
    el: document.getElementById('grid'),
    data: {
        api: {
            readData: { url: '/board/data', method: 'GET' },
//            CreateData: { url: '/board/data', method: 'POST' },
//            updateData: { url: '/board/data', method: 'PUT' },
//            deleteData: { url: '/board/data', method: 'DELETE' }
        }
    },
    scrollX: false,
    scrollY: false,
    minBodyHeight: 30,
//    rowHeaders: ['rowNum'],
    pageOptions: {
        perPage: 5
    },
    columns: [
        {
            header: '순번',
            name: 'id'
        },
        {
            header: '제목',
            name: 'title',
            editor: 'text'
        },
        {
            header: '내용',
            name: 'content',
            editor: 'text'
        },
        {
            header: '작성자',
            name: 'writer'
        },
        {
            header: '조회수',
            name: 'viewCnt'
        }
    ]
}); // grid

//grid.resetData( result );




