const container = document.getElementById('calendar');
const options = {
  defaultView: 'month',
  timezone: {
    zones: [
      {
        timezoneName: 'Asia/Seoul',
        displayLabel: 'Seoul',
      },
      {
        timezoneName: 'Europe/London',
        displayLabel: 'London',
      },
    ],
  },
  calendars: [
    {
      id: 'cal1',
      name: '개인',
      backgroundColor: '#03bd9e',
    },
    {
      id: 'cal2',
      name: '직장',
      backgroundColor: '#00a9ff',
    },
  ],
};

const Calendar = tui.Calendar;
const calendar = new Calendar(container, options);

calendar.setOptions({
  useFormPopup: true,
  useDetailPopup: true,
});

//calendar.on('clickEvent', ({ event }) => {
//  const el = document.getElementById('clicked-event');
//  el.innerText = event.title;
//});

calendar.createEvents([
    {
        id: "event2",
        calendarId: "cal2",
        title: "회의",
        start: "2023-09-11T22:00:00",
        end: "2023-09-13T12:00:00",
        isAllday: true
    },
    $.ajax({
        type: "GET",
            url: "/schedule/data",
            success: function(data) {
                console.log(JSON.stringify(data));
                return data;
            },
            error: function(err) {
                alert("Error: " + err);
            }
    })
]);



//// 일정 생성 이벤트
//calendar.on('beforeCreateSchedule', scheduleData => {
//  const schedule = {
//    calendarId: 'Major Lecture',
//    id: String(Math.random() * 100000000000000000),
//    title: scheduleData.title,
//    isAllDay: scheduleData.isAllDay,
//    start: scheduleData.start,
//    end: scheduleData.end,
//    category: scheduleData.isAllDay ? 'allday' : 'time'
//  };
//
//  calendar.createSchedules([schedule]);
//
//  alert('일정 생성 완료');
//});
//
//// 일정 편집 이벤트
//calendar.on('beforeUpdateSchedule', scheduleData => {
//  const {schedule} = scheduleData;
//
//  calendar.updateSchedule(schedule.id, schedule.calendarId, schedule);
//});
//
//// 일정 삭제 이벤트
//calendar.on('beforeDeleteSchedule', scheduleData => {
//  const {schedule, start, end} = scheduleData;
//
//  schedule.start = start;
//  schedule.end = end;
//  calendar.deleteSchedule(schedule.id, schedule.calendarId);
//});
