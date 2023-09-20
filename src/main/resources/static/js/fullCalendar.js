const calendarEl = document.getElementById('calendar');
let calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth, timeGridWeek, timeGridDay'
    },
    // 달력 클릭 시 이벤트 생성
    select: (info) => {
        createEvent(info);
    },
    // 이벤트 클릭 시 수정, 삭제
    eventClick: (info) => {
        updateEvent(info);
    },
    editable: true,
    droppable: true,
    selectable: true,
    displayEventTime: false,
    // 캘린더에 Data 전달
    events: {
        url : '/schedule/data',
        method: 'GET'
    }
});
// 캘린더 생성
calendar.render();

// 일정 Insert 함수
const createEvent = (info) => {

    initModal(info);
    createUpdateButton();
}

// 일정 Update 함수
const updateEvent = (info) => {

    initModal(info);
    createUpdateButton();
    deleteButton();
}

// 모달 초기화 함수
const initModal = (info) => {
    $("#calendar_id").val("");
    $("#calendar_title").val("");
    $("#calendar_group_id").val("");
    $("#calendar_start_date").val("");
    $("#calendar_end_date").val("");

    if(info.jsEvent.type == "mouseup") {
        $("#addCalendar").html("추가");
        $("#removeCalendar").hide();

        // 모달에 선택한 날짜 반영
        $("#calendar_start_date").val(info.startStr);
        $("#calendar_end_date").val(info.endStr);
    }
    else if(info.jsEvent.type == "click") {
        $("#addCalendar").html("수정");
        $("#removeCalendar").show();

        // 모달에 선택한 일정 반영
        $("#calendar_id").val(info.event._def.publicId);
        $("#calendar_title").val(info.event._def.title);
        $("#calendar_group_id").val(info.event._def.groupId);
        $("#calendar_start_date").val(toStringByFormatting(info.event._instance.range.start));
        $("#calendar_end_date").val(toStringByFormatting(info.event._instance.range.end));
    }

    // modal 나타내기
    $("#calendarModal").modal("show");
}

// AJAX 요청 중복 방지
var isAjaxRequestInProgress = false;

// 추가 or 수정 버튼 클릭 시 AJAX 통신
const createUpdateButton = () => {
    $("#addCalendar").on("click", () => {
        if (isAjaxRequestInProgress) {
            return; // 이미 AJAX 요청이 진행 중이면 더 이상 실행하지 않음
        }
        // AJAX 요청 실행 중으로 표시
        isAjaxRequestInProgress = true;

        var id = $("#calendar_id").val();
        var title = $("#calendar_title").val();
        var group_id = $("#calendar_group_id").val();
        var start_date = $("#calendar_start_date").val();
        var end_date = $("#calendar_end_date").val();

        // 입력한 데이터 검증
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
            var schedule = {
                "id" : id,
                "title" : title,
                "groupId" : group_id,
                "start" : start_date,
                "end" : end_date
            }

            if($("#addCalendar").html() === "추가") {
                var API_METHOD = "POST";
            }
            else if($("#addCalendar").html() === "수정") {
                var API_METHOD = "PUT";
            }

            // Controller에 Data(JSON) 전달
            const req = $.ajax({
                url: "/schedule/data",
                method: API_METHOD,
                dataType: "text",
                data: schedule, // data는 json 형태로
                success: (res) => {
                    // 캘린더 화면에 변경된 데이터 다시 가져오기
                    calendar.refetchEvents();

                    // 모달 창 숨기기
                    $('#calendarModal').modal('hide');

                    // AJAX 요청 완료 후 상태 초기화
                    isAjaxRequestInProgress = false;
                },
                error: (error) => {
                    console.error(error);

                    isAjaxRequestInProgress = false;
                }
            })
        }
    });
}

// 삭제 버튼 클릭 시 AJAX 통신
const deleteButton = () => {

    $("#removeCalendar").on("click", () => {
        if (isAjaxRequestInProgress) {
            return;
        }
        isAjaxRequestInProgress = true;

        var id = $("#calendar_id").val();

        var schedule = {
            "id" : id
        }

        $.ajax({
            url: "/schedule/data",
            method: "DELETE",
            dataType: "text",
            data: schedule, // data는 json 형태로
            success: () => {
                calendar.refetchEvents();

                $('#calendarModal').modal('hide');

                isAjaxRequestInProgress = false;
            },
            error: (error) => {
                console.error(error);
                isAjaxRequestInProgress = false;
            }
        })
    });
}





// 날짜 포맷 변환 시 [월,일]이 10자리 아래면 왼쪽에 0 추가 함수
const leftPad = (value) => {
    if (value >= 10) {
        return value;
    }
    return `0${value}`;
}

// 날짜 형식 변환 함수 (yyyy-MM-dd)
const toStringByFormatting = (source, delimiter = '-') => {
    const year = source.getFullYear();
    const month = leftPad(source.getMonth() + 1);
    const day = leftPad(source.getDate());

    return [year, month, day].join(delimiter);
}

