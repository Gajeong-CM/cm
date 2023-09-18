document.addEventListener('DOMContentLoaded', function() {
    $(function() {
        var request = $.ajax({
            url: "/schedule/data",
            method: "GET",
            dataType: "json"
        });
        request.done(function(data) {
            console.log(data);

            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title addEventButton',
                    right: 'dayGridMonth, timeGridWeek, timeGridDay'
                },
                editable: true,
                droppable: true,
                selectable: true,
                displayEventTime: false,
                //TODO: drop은 뭔지 모르겠음;;
                drop: function (arg) {
                    // is the "remove after drop" checkbox checked?
                    if (document.getElementById('drop-remove').checked) {
                        // if so, remove the element from the "Draggable Events" list
                        arg.draggedEl.parentNode.removeChild(arg.draggedEl);
                    }
                },
                // 일정 추가 버튼
                customButtons: {
                    addEventButton: { // 추가한 버튼 설정
                        text : "일정 추가",  // 버튼 내용
                        click : function(){ // 버튼 클릭 시 이벤트 추가
                            $("#calendarModal").modal("show"); // modal 나타내기

                            $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
                                var title = $("#calendar_title").val();
                                var group_id = $("#calendar_group_id").val();
                                var start_date = $("#calendar_start_date").val();
                                var end_date = $("#calendar_end_date").val();

                                //내용 입력 여부 확인
                                if(title == null || title == ""){
                                    alert("내용을 입력하세요.");
                                }else if(group_id == null || group_id == ""){
                                     alert("그룹 ID를 입력하세요.");
                                }else if(start_date == "" || end_date ==""){
                                    alert("날짜를 입력하세요.");
                                }else if(new Date(end_date)- new Date(start_date) < 0){ // date 타입으로 변경 후 확인
                                    alert("종료일이 시작일보다 먼저입니다.");
                                }else{ // 정상 입력 시
                                    //전송할 객체 생성
                                    var obj = {
                                        "title" : title,
                                        "groupId" : group_id,
                                        "start" : start_date,
                                        "end" : end_date
                                    }

                                    console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                                    // Controller에 Data(JSON)를 POST로 전달
                                    $.ajax({
                                        url: "/schedule/data",
                                        method: "POST",
                                        dataType: "json",
                                        data: obj // data는 항상 json 형태로..
                                    })
                                }
                            });
                        }
                    }
                },
                // 캘린더에 Data 전달
                events: data
            });
            // 캘린더 생성
            calendar.render();
        });
        request.fail(function(jqXHR, textStatus) {
            alert("Request failed" + textStatus);
        });
    });
});