/* 즐겨찾기 */
CREATE TABLE tblLineRoute (
	seq NUMBER NOT NULL, /* 즐겨찾기 번호 */
	cusseq NUMBER NOT NULL, /* 고객번호 */
	lsseq NUMBER NOT NULL, /* 호선+역 번호 */
	delflag NUMBER /* 삭제여부 */
);

/* 지하철 호선루트 */
CREATE TABLE tblLineRoute (
	seq NUMBER NOT NULL, /* 루트 번호 */
	stateseq NUMBER NOT NULL, /* 상태번호 */
	directionseq NUMBER NOT NULL, /* 방향 번호 */
	linedirecseq NUMBER /* 호선+행번호 */
);

ALTER TABLE tblLineRoute RENAME COLUMN cusseq TO stateseq;
ALTER TABLE tblLineRoute RENAME COLUMN lsseq TO directionseq;

create sequence LineRoute_seq;

COMMENT ON TABLE tblLineRoute IS '지하철 호선루트';

COMMENT ON COLUMN tblLineRoute.seq IS '루트 번호';

COMMENT ON COLUMN tblLineRoute.stateseq IS '상태번호';

COMMENT ON COLUMN tblLineRoute.directionseq IS '방향 번호';

COMMENT ON COLUMN tblLineRoute.linedirecseq IS '호선,행번호';

CREATE UNIQUE INDEX PK_tblLineRoute
	ON tblLineRoute (
		seq ASC
	);

ALTER TABLE tblLineRoute
	ADD
		CONSTRAINT PK_tblLineRoute
		PRIMARY KEY (
			seq
		);

/* 지하철 역 */
CREATE TABLE tblStation (
	seq NUMBER NOT NULL, /* 역번호 */
	name VARCHAR2(30) NOT NULL /* 역 이름 */
);

COMMENT ON TABLE tblStation IS '지하철 역';

COMMENT ON COLUMN tblStation.seq IS '역번호';

COMMENT ON COLUMN tblStation.name IS '역 이름';

CREATE UNIQUE INDEX PK_tblStation
	ON tblStation (
		seq ASC
	);

ALTER TABLE tblStation
	ADD
		CONSTRAINT PK_tblStation
		PRIMARY KEY (
			seq
		);

/* 호선+역 */
CREATE TABLE tblLineStation (
	seq NUMBER NOT NULL, /* 호선+역번호 */
	door NUMBER NOT NULL, /* 문 위치 */
	staorder NUMBER NOT NULL, /* 역 순서 */
	linerouteseq NUMBER NOT NULL, /* 호선루트 번호 */
	staseq NUMBER NOT NULL /* 역번호 */
);

COMMENT ON TABLE tblLineStation IS '호선+역';

COMMENT ON COLUMN tblLineStation.seq IS '호선+역번호';

COMMENT ON COLUMN tblLineStation.door IS '문 위치';

COMMENT ON COLUMN tblLineStation.staorder IS '역 순서';

COMMENT ON COLUMN tblLineStation.linerouteseq IS '호선루트 번호';

COMMENT ON COLUMN tblLineStation.staseq IS '역번호';

CREATE UNIQUE INDEX PK_tblLineStation
	ON tblLineStation (
		seq ASC
	);

ALTER TABLE tblLineStation
	ADD
		CONSTRAINT PK_tblLineStation
		PRIMARY KEY (
			seq
		);


/* 기차 */
CREATE TABLE tblTrain (
	seq NUMBER NOT NULL, /* 기차번호 */
	linerouteseq NUMBER NOT NULL, /* 호선루트 번호 */
	lineseq NUMBER NOT NULL /* 호선번호 */
);

COMMENT ON TABLE tblTrain IS '기차';

COMMENT ON COLUMN tblTrain.seq IS '기차번호';

COMMENT ON COLUMN tblTrain.linerouteseq IS '호선루트 번호';

COMMENT ON COLUMN tblTrain.lineseq IS '호선번호';

CREATE UNIQUE INDEX PK_tblTrain
	ON tblTrain (
		seq ASC
	);

ALTER TABLE tblTrain
	ADD
		CONSTRAINT PK_tblTrain
		PRIMARY KEY (
			seq
		);

/* 기차위치 */
CREATE TABLE tblTrainlocation (
	seq NUMBER NOT NULL, /* 기차 위치번호 */
	time DATE NOT NULL, /* 시간 */
	lsseq NUMBER NOT NULL, /* 호선+역번호 */
	trseq NUMBER NOT NULL /* 기차번호 */
);

COMMENT ON TABLE tblTrainlocation IS '기차위치';

COMMENT ON COLUMN tblTrainlocation.seq IS '기차 위치번호';

COMMENT ON COLUMN tblTrainlocation.time IS '시간';

COMMENT ON COLUMN tblTrainlocation.lsseq IS '호선+역번호';

COMMENT ON COLUMN tblTrainlocation.trseq IS '기차번호';

CREATE UNIQUE INDEX PK_tblTrainlocation
	ON tblTrainlocation (
		seq ASC
	);

ALTER TABLE tblTrainlocation
	ADD
		CONSTRAINT PK_tblTrainlocation
		PRIMARY KEY (
			seq
		);

/* 불편사항 */
CREATE TABLE tblComplain (
	seq NUMBER NOT NULL, /* 불편사항 번호 */
	content VARCHAR2(300) NOT NULL, /* 내용 */
	comdate DATE NOT NULL, /* 날짜 */
	delflag NUMBER NOT NULL, /* delflag */
	locseq NUMBER NOT NULL, /* 기차 위치번호 */
	cusseq NUMBER NOT NULL /* 고객번호 */
);

COMMENT ON TABLE tblComplain IS '불편사항';

COMMENT ON COLUMN tblComplain.seq IS '불편사항 번호';

COMMENT ON COLUMN tblComplain.content IS '내용';

COMMENT ON COLUMN tblComplain.comdate IS '날짜';

COMMENT ON COLUMN tblComplain.delflag IS 'delflag';

COMMENT ON COLUMN tblComplain.locseq IS '기차 위치번호';

COMMENT ON COLUMN tblComplain.cusseq IS '고객번호';

CREATE UNIQUE INDEX PK_tblComplain
	ON tblComplain (
		seq ASC
	);

ALTER TABLE tblComplain
	ADD
		CONSTRAINT PK_tblComplain
		PRIMARY KEY (
			seq
		);

/* 기차 칸 */
CREATE TABLE tblTrainSeat (
	seq NUMBER NOT NULL, /* 칸 번호 */
	avgnum NUMBER NOT NULL, /* 인원수 */
	trseq NUMBER NOT NULL /* 기차번호 */
);

COMMENT ON TABLE tblTrainSeat IS '기차 칸';

COMMENT ON COLUMN tblTrainSeat.seq IS '칸 번호';

COMMENT ON COLUMN tblTrainSeat.avgnum IS '인원수';

COMMENT ON COLUMN tblTrainSeat.trseq IS '기차번호';

CREATE UNIQUE INDEX PK_tblTrainSeat
	ON tblTrainSeat (
		seq ASC
	);

ALTER TABLE tblTrainSeat
	ADD
		CONSTRAINT PK_tblTrainSeat
		PRIMARY KEY (
			seq
		);

/* 기차 운행 정보  */
CREATE TABLE tblTime (
	seq NUMBER NOT NULL, /* 시간 번호 */
	days VARCHAR2(10) NOT NULL, /* 요일(평일/주말/공휴일) */
	firstTime DATE NOT NULL, /* 첫차 시간 */
	lastTime DATE NOT NULL, /* 막차 시간 */
	term NUMBER NOT NULL, /* 배차 시간 */
	runnumber NUMBER NOT NULL, /* 운행 대수 */
	lineseq NUMBER NOT NULL /* 루트 번호 */
);

COMMENT ON TABLE tblTime IS '기차 운행 정보 ';

COMMENT ON COLUMN tblTime.seq IS '시간 번호';

COMMENT ON COLUMN tblTime.days IS '요일(평일/주말/공휴일)';

COMMENT ON COLUMN tblTime.firstTime IS '첫차 시간';

COMMENT ON COLUMN tblTime.lastTime IS '막차 시간';

COMMENT ON COLUMN tblTime.term IS '배차 시간';

COMMENT ON COLUMN tblTime.runnumber IS '운행 대수';

COMMENT ON COLUMN tblTime.lineseq IS '루트 번호';

CREATE UNIQUE INDEX PK_tblTime
	ON tblTime (
		seq ASC
	);

ALTER TABLE tblTime
	ADD
		CONSTRAINT PK_tblTime
		PRIMARY KEY (
			seq
		);

/* 실시간혼잡도 */
CREATE TABLE tblCongestion (
	seq NUMBER NOT NULL, /* 번호 */
	peoplenum NUMBER NOT NULL, /* 인원수 */
	locseq NUMBER NOT NULL, /* 기차 위치번호 */
	tsseq NUMBER NOT NULL /* 칸 번호 */
);

COMMENT ON TABLE tblCongestion IS '실시간혼잡도';

COMMENT ON COLUMN tblCongestion.seq IS '번호';

COMMENT ON COLUMN tblCongestion.peoplenum IS '인원수';

COMMENT ON COLUMN tblCongestion.locseq IS '기차 위치번호';

COMMENT ON COLUMN tblCongestion.tsseq IS '칸 번호';

CREATE UNIQUE INDEX PK_tblCongestion
	ON tblCongestion (
		seq ASC
	);

ALTER TABLE tblCongestion
	ADD
		CONSTRAINT PK_tblCongestion
		PRIMARY KEY (
			seq
		);

/* 관리자 */
CREATE TABLE tblAdmin (
	seq NUMBER NOT NULL, /* 관리자 번호 */
	id VARCHAR2(10) NOT NULL, /* id */
	pw VARCHAR2(10) NOT NULL /* pw */
);

COMMENT ON TABLE tblAdmin IS '관리자';

COMMENT ON COLUMN tblAdmin.seq IS '관리자 번호';

COMMENT ON COLUMN tblAdmin.id IS 'id';

COMMENT ON COLUMN tblAdmin.pw IS 'pw';

CREATE UNIQUE INDEX PK_tblAdmin
	ON tblAdmin (
		seq ASC
	);

ALTER TABLE tblAdmin
	ADD
		CONSTRAINT PK_tblAdmin
		PRIMARY KEY (
			seq
		);

/* 불편사항 답변 */
CREATE TABLE tblAnswer (
	seq NUMBER NOT NULL, /* 답변 번호 */
	content VARCHAR2(300) NOT NULL, /* 답변 */
	delflag NUMBER NOT NULL, /* delflag */
	comseq NUMBER NOT NULL, /* 불편사항 번호 */
	adseq NUMBER NOT NULL /* 관리자 번호 */
);

COMMENT ON TABLE tblAnswer IS '불편사항 답변';

COMMENT ON COLUMN tblAnswer.seq IS '답변 번호';

COMMENT ON COLUMN tblAnswer.content IS '답변';

COMMENT ON COLUMN tblAnswer.delflag IS 'delflag';

COMMENT ON COLUMN tblAnswer.comseq IS '불편사항 번호';

COMMENT ON COLUMN tblAnswer.adseq IS '관리자 번호';

CREATE UNIQUE INDEX PK_tblAnswer
	ON tblAnswer (
		seq ASC
	);

ALTER TABLE tblAnswer
	ADD
		CONSTRAINT PK_tblAnswer
		PRIMARY KEY (
			seq
		);


/* 고객 */
CREATE TABLE tblCustomer (
	seq NUMBER NOT NULL, /* 고객번호 */
	id VARCHAR2(10) NOT NULL, /* id */
	pw VARCHAR2(20) NOT NULL, /* pw */
	tel VARCHAR2(15) NOT NULL /* 전화번호 */
);

COMMENT ON TABLE tblCustomer IS '고객';

COMMENT ON COLUMN tblCustomer.seq IS '고객번호';

COMMENT ON COLUMN tblCustomer.id IS 'id';

COMMENT ON COLUMN tblCustomer.pw IS 'pw';

COMMENT ON COLUMN tblCustomer.tel IS '전화번호';

CREATE UNIQUE INDEX PK_tblCustomer
	ON tblCustomer (
		seq ASC
	);

ALTER TABLE tblCustomer
	ADD
		CONSTRAINT PK_tblCustomer
		PRIMARY KEY (
			seq
		);

/* 도착역 */
CREATE TABLE tblArrival (
	seq NUMBER NOT NULL, /* 도착역 번호 */
	delflag NUMBER NOT NULL, /* delflag */
	cusseq NUMBER NOT NULL, /* 고객번호 */
	lsseq NUMBER NOT NULL /* 호선+역번호 */
);

COMMENT ON TABLE tblArrival IS '도착역';

COMMENT ON COLUMN tblArrival.seq IS '도착역 번호';

COMMENT ON COLUMN tblArrival.delflag IS 'delflag';

COMMENT ON COLUMN tblArrival.cusseq IS '고객번호';

COMMENT ON COLUMN tblArrival.lsseq IS '호선+역번호';

CREATE UNIQUE INDEX PK_tblArrival
	ON tblArrival (
		seq ASC
	);

ALTER TABLE tblArrival
	ADD
		CONSTRAINT PK_tblArrival
		PRIMARY KEY (
			seq
		);

/* 출발역 */
CREATE TABLE tblStart (
	seq NUMBER NOT NULL, /* 출발역 번호 */
	delflag NUMBER NOT NULL, /* delflag */
	cusseq NUMBER NOT NULL, /* 고객번호 */
	lsseq NUMBER NOT NULL /* 호선+역번호 */
);

COMMENT ON TABLE tblArrival IS '출발역';

COMMENT ON COLUMN tblArrival.seq IS '출발역 번호';

COMMENT ON COLUMN tblArrival.delflag IS 'delflag';

COMMENT ON COLUMN tblArrival.cusseq IS '고객번호';

COMMENT ON COLUMN tblArrival.lsseq IS '호선+역번호';

CREATE UNIQUE INDEX PK_tblStart
	ON tblArrival (
		seq asc
	);

ALTER TABLE tblStart
	ADD
		CONSTRAINT PK_tblStart
		PRIMARY KEY (
			seq
		);

/* 환승구간 */
CREATE TABLE tblTransfer (
	seq NUMBER NOT NULL, /* 번호 */
	transsection VARCHAR2(10) NOT NULL, /* 환승구간 */
	ls_1seq NUMBER NOT NULL, /* 호선+역번호 */
	ls_2seq NUMBER NOT NULL /* 환승 방향 */
);

COMMENT ON TABLE tblTransfer IS '환승구간';

COMMENT ON COLUMN tblTransfer.seq IS '번호';

COMMENT ON COLUMN tblTransfer.transsection IS '환승구간';

COMMENT ON COLUMN tblTransfer.ls_1seq IS '호선+역번호';

COMMENT ON COLUMN tblTransfer.ls_2seq IS '환승 방향';

CREATE UNIQUE INDEX PK_tblTransfer
	ON tblTransfer (
		seq ASC
	);

ALTER TABLE tblTransfer
	ADD
		CONSTRAINT PK_tblTransfer
		PRIMARY KEY (
			seq
		);

/* 기차 스케줄 */
CREATE TABLE tblSchedule (
	seq NUMBER NOT NULL, /* 번호 */
	days DATE NOT NULL, /* 날짜 */
	starttime DATE NOT NULL, /* 출발시간 */
	endtime DATE NOT NULL, /* 운행 종료 시간  */
	runorder NUMBER NOT NULL, /* 운행 순서 */
	trainseq NUMBER NOT NULL /* 기차번호 */
);

COMMENT ON TABLE tblSchedule IS '기차 스케줄';

COMMENT ON COLUMN tblSchedule.seq IS '번호';

COMMENT ON COLUMN tblSchedule.days IS '날짜';

COMMENT ON COLUMN tblSchedule.starttime IS '출발시간';

COMMENT ON COLUMN tblSchedule.endtime IS '운행 종료 시간 ';

COMMENT ON COLUMN tblSchedule.runorder IS '운행 순서';

COMMENT ON COLUMN tblSchedule.trainseq IS '기차번호';

CREATE UNIQUE INDEX PK_tblSchedule
	ON tblSchedule (
		seq ASC
	);

ALTER TABLE tblSchedule
	ADD
		CONSTRAINT PK_tblSchedule
		PRIMARY KEY (
			seq
		);


/* 호선 상태 */
CREATE TABLE tblState (
	seq NUMBER NOT NULL, /* 번호 */
	state VARCHAR2(30) NOT NULL /* 상태 */
);

COMMENT ON TABLE tblState IS '호선 상태';

COMMENT ON COLUMN tblState.seq IS '번호';

COMMENT ON COLUMN tblState.state IS '상태';

CREATE UNIQUE INDEX PK_tblState
	ON tblState (
		seq ASC
	);

ALTER TABLE tblState
	ADD
		CONSTRAINT PK_tblState
		PRIMARY KEY (
			seq
		);

/* 호선 방향 */
CREATE TABLE tblDirection (
	seq NUMBER NOT NULL, /* 번호 */
	direction VARCHAR2(30) NOT NULL /* 방향 */
);

COMMENT ON TABLE tblDirection IS '호선 방향';

COMMENT ON COLUMN tblDirection.seq IS '번호';

COMMENT ON COLUMN tblDirection.direction IS '방향';

CREATE UNIQUE INDEX PK_tblDirection
	ON tblDirection (
		seq ASC
	);

ALTER TABLE tblDirection
	ADD
		CONSTRAINT PK_tblDirection
		PRIMARY KEY (
			seq
		);

/* 호선 */
CREATE TABLE tblLine (
	seq NUMBER NOT NULL, /* 번호 */
	name VARCHAR2(30) NOT NULL /* 호선 이름 */
);

COMMENT ON TABLE tblLine IS '호선';

COMMENT ON COLUMN tblLine.seq IS '번호';

COMMENT ON COLUMN tblLine.name IS '호선 이름';

CREATE UNIQUE INDEX PK_tblLine
	ON tblLine (
		seq ASC
	);

ALTER TABLE tblLine
	ADD
		CONSTRAINT PK_tblLine
		PRIMARY KEY (
			seq
		);

/* 호선+행 */
CREATE TABLE tblLineDirec (
	seq NUMBER NOT NULL, /* 번호 */
	destination VARCHAR2(20) NOT NULL, /* 방면 */
	lineseq NUMBER NOT NULL /* 호선번호 */
);

COMMENT ON TABLE tblLineDirec IS '호선+행';

COMMENT ON COLUMN tblLineDirec.seq IS '번호';

COMMENT ON COLUMN tblLineDirec.destination IS '방면';

COMMENT ON COLUMN tblLineDirec.lineseq IS '호선번호';

CREATE UNIQUE INDEX PK_tblLineDirec
	ON tblLineDirec (
		seq ASC
	);
    
/* 즐겨찾기 */
CREATE TABLE tblBookmark (
	seq NUMBER NOT NULL primary key, /* 즐겨찾기 번호 */
	cusseq NUMBER NOT NULL, /* 고객번호 */
	lsseq NUMBER NOT NULL, /* 호선+역 번호 */
	delflag NUMBER /* 삭제여부 */
);

ALTER TABLE tblBookmark
	ADD
		CONSTRAINT FK_tblBookmark_TO_tblCustomer
		FOREIGN KEY (
			cusseq
		)
		REFERENCES tblCustomer (
			seq
		);
        
ALTER TABLE tblBookmark
	ADD
		CONSTRAINT FK_Bookmark_TO_lineStation
		FOREIGN KEY (
			lsseq
		)
		REFERENCES tblLineStation (
			seq
		);


ALTER TABLE tblLineDirec
	ADD
		CONSTRAINT PK_tblLineDirec
		PRIMARY KEY (
			seq
		);

ALTER TABLE tblLineRoute
	ADD
		CONSTRAINT FK_tblState_TO_tblLineRoute
		FOREIGN KEY (
			stateseq
		)
		REFERENCES tblState (
			seq
		);

ALTER TABLE tblLineRoute
	ADD
		CONSTRAINT FK_tblDirection_LineRoute
		FOREIGN KEY (
			directionseq
		)
		REFERENCES tblDirection (
			seq
		);

ALTER TABLE tblLineRoute
	ADD
		CONSTRAINT FK_tblLineDirec_TO_LineRoute
		FOREIGN KEY (
			linedirecseq
		)
		REFERENCES tblLineDirec (
			seq
		);

ALTER TABLE tblLineStation
	ADD
		CONSTRAINT FK_tblLineRoute_TO_LineStation
		FOREIGN KEY (
			linerouteseq
		)
		REFERENCES tblLineRoute (
			seq
		);

ALTER TABLE tblLineStation
	ADD
		CONSTRAINT FK_tblStation_TO_LineStation
		FOREIGN KEY (
			staseq
		)
		REFERENCES tblStation (
			seq
		);

ALTER TABLE tblTrain
	ADD
		CONSTRAINT FK_tblLineRoute_TO_tblTrain
		FOREIGN KEY (
			linerouteseq
		)
		REFERENCES tblLineRoute (
			seq
		);

ALTER TABLE tblTrain
	ADD
		CONSTRAINT FK_tblLine_TO_tblTrain
		FOREIGN KEY (
			lineseq
		)
		REFERENCES tblLine (
			seq
		);

ALTER TABLE tblTrainlocation
	ADD
		CONSTRAINT FK_LineStation_Trainlocation
		FOREIGN KEY (
			lsseq
		)
		REFERENCES tblLineStation (
			seq
		);

ALTER TABLE tblTrainlocation
	ADD
		CONSTRAINT FK_tblTrain_TO_Trainlocation
		FOREIGN KEY (
			trseq
		)
		REFERENCES tblTrain (
			seq
		);

ALTER TABLE tblComplain
	ADD
		CONSTRAINT FK_Trainlocation_TO_Complain
		FOREIGN KEY (
			locseq
		)
		REFERENCES tblTrainlocation (
			seq
		);

ALTER TABLE tblComplain
	ADD
		CONSTRAINT FK_tblCustomer_TO_tblComplain
		FOREIGN KEY (
			cusseq
		)
		REFERENCES tblCustomer (
			seq
		);

ALTER TABLE tblTrainSeat
	ADD
		CONSTRAINT FK_tblTrain_TO_tblTrainSeat
		FOREIGN KEY (
			trseq
		)
		REFERENCES tblTrain (
			seq
		);

ALTER TABLE tblTime
	ADD
		CONSTRAINT FK_tblLineRoute_TO_tblTime
		FOREIGN KEY (
			lineseq
		)
		REFERENCES tblLineRoute (
			seq
		);

ALTER TABLE tblCongestion
	ADD
		CONSTRAINT FK_Trainlocation_TO_Congestion
		FOREIGN KEY (
			locseq
		)
		REFERENCES tblTrainlocation (
			seq
		);

ALTER TABLE tblCongestion
	ADD
		CONSTRAINT FK_TrainSeat_TO_tblCongestion
		FOREIGN KEY (
			tsseq
		)
		REFERENCES tblTrainSeat (
			seq
		);

ALTER TABLE tblAnswer
	ADD
		CONSTRAINT FK_tblComplain_TO_tblAnswer
		FOREIGN KEY (
			comseq
		)
		REFERENCES tblComplain (
			seq
		);

ALTER TABLE tblAnswer
	ADD
		CONSTRAINT FK_tblAdmin_TO_tblAnswer
		FOREIGN KEY (
			adseq
		)
		REFERENCES tblAdmin (
			seq
		);

ALTER TABLE tblStart
	ADD
		CONSTRAINT FK_tblCustomer_TO_tblStart
		FOREIGN KEY (
			cusseq
		)
		REFERENCES tblCustomer (
			seq
		);

ALTER TABLE tblStart
	ADD
		CONSTRAINT FK_tblLineStation_TO_tblStart
		FOREIGN KEY (
			lsseq
		)
		REFERENCES tblLineStation (
			seq
		);

ALTER TABLE tblArrival
	ADD
		CONSTRAINT FK_tblCustomer_TO_tblArrival
		FOREIGN KEY (
			cusseq
		)
		REFERENCES tblCustomer (
			seq
		);

ALTER TABLE tblArrival
	ADD
		CONSTRAINT FK_LineStation_TO_tblArrival
		FOREIGN KEY (
			lsseq
		)
		REFERENCES tblLineStation (
			seq
		);

ALTER TABLE tblTransfer
	ADD
		CONSTRAINT FK_LineStation_TO_tblTransfer
		FOREIGN KEY (
			ls_1seq
		)
		REFERENCES tblLineStation (
			seq
		);


ALTER TABLE tblSchedule
	ADD
		CONSTRAINT FK_tblTrain_TO_tblSchedule
		FOREIGN KEY (
			trainseq
		)
		REFERENCES tblTrain (
			seq
		);


ALTER TABLE tblLineDirec
	ADD
		CONSTRAINT FK_tblLine_TO_tblLineDirec
		FOREIGN KEY (
			lineseq
		)
		REFERENCES tblLine (
			seq
		);
        
        

create sequence schedule_seq;
create sequence line_seq;
create sequence lineDirec_seq;
create sequence congestion_seq;
create sequence train_seq;
create sequence direction_seq;
create sequence state_seq;
create sequence trainSeat_seq;
create sequence trainlocation_seq;
create sequence lineRoute_seq;
create sequence time_seq;
create sequence start_seq;
create sequence lineStation_seq;
create sequence station_seq;
create sequence transfer_seq;
create sequence arrival_seq;
create sequence customer_seq;
create sequence complain_seq;
create sequence answer_seq;
create sequence admin_seq;
create sequence bookmark_seq;


ALTER TABLE tblComplain MODIFY delflag DEFAULT 0;
ALTER TABLE tblAnswer MODIFY delflag DEFAULT 0;
ALTER TABLE tblBookmark MODIFY delflag DEFAULT 0;

ALTER TABLE tblComplain ADD answer number default 1;

ALTER TABLE tblLineRoute RENAME COLUMN linedircseq TO linedirecseq;

ALTER TABLE tblLineRoute
	ADD
		CONSTRAINT FK_LineRoute_LineDirec
		FOREIGN KEY (
			linedirecseq
		)
		REFERENCES tblLineDirec (
			seq
		);

select * from tblComplain;
update tblComplain set answer=0; 
--답변하면 0 안하면 1 default 1
commit;