const gridData = [
    {
        name: 'ko',
        type: 'student',
        release: '20230901'
    }
]


const grid = new tui.Grid({
      el: document.getElementById('grid'),
      data: gridData,
      scrollX: false,
      scrollY: false,
      columns: [
        {
          header: 'Name',
          name: 'name'
        },
        {
          header: 'Type',
          name: 'type'
        },
        {
          header: 'Release',
          name: 'release'
        }
      ],
      draggable: true
    });