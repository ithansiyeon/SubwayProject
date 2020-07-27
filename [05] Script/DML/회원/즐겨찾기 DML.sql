--로그인
select * from tblCustomer order by seq;
select * from tblAdmin order by seq;


--즐겨찾기 조회
--(2)역삼역 3분 후 도착 - 혼잡

select rownum, ll.name as lname, ld.destination, s.name as sname, bm.seq
from tblBookmark bm inner join tblLinestation ls on bm.lsseq=ls.seq
inner join tblStation s on ls.staseq=s.seq
inner join tblLineRoute lr on ls.linerouteseq=lr.seq
inner join tblLineDirec ld on lr.linedirecseq=ld.seq
inner join tblLine ll on ld.lineseq=ll.seq
where bm.cusseq=1 and bm.delflag=0
order by rownum, bm.cusseq,bm.seq;



select bm.cusseq,ll.name, ld.destination, s.name
from tblBookmark bm inner join tblLinestation ls on bm.lsseq=ls.seq
inner join tblStation s on ls.staseq=s.seq
inner join tblLineRoute lr on ls.linerouteseq=lr.seq
inner join tblLineDirec ld on lr.linedirecseq=ld.seq
inner join tblLine ll on ld.lineseq=ll.seq
where bm.delflag=0
order by bm.cusseq;



--[번호]rownum	[호선]	[역이름]		[방면]
select rownum, ll.name as lname, ld.destination, s.name as sname
from tblLinestation ls  inner join tblStation s on ls.staseq=s.seq
inner join tblLineRoute lr on ls.linerouteseq=lr.seq
inner join tblLineDirec ld on lr.linedirecseq=ld.seq
inner join tblLine ll on ld.lineseq=ll.seq
where sname = '신도림';


--역 이름 검색
select rownum, ss.name as sname, ll.name as lname, ld.destination as des
from tblLineStation ls inner join tblStation ss on ls.staseq=ss.seq
inner join tblLineRoute lr on ls.linerouteseq=lr.seq
inner join tblLineDirec ld on lr.linedirecseq=ld.seq
inner join tblLine ll on ld.lineseq=ll.seq
where ss.name = '신도림';


--기차 위치 찾기
select tl.seq, to_char(tl.time,'yyyy-mm-dd-hh24-mi') as now, ls.staorder,tl.trseq, s.name  
from tblTrainLocation tl inner join tblLineStation ls on tl.lsseq=ls.seq
inner join tblStation s on ls.staseq=s.seq
where tl.trseq in (select seq from tblTrain where linerouteseq = 1) and ls.seq in (23,22,21) and to_char(tl.time,'yyyy-mm-dd') = '2020-07-16'
order by tl.seq desc;


--가장 가까운 기차 번호 찾아서 위치 받기
select tl.seq, to_char(tl.time,'yyyy-mm-dd-hh24-mi') as now, ls.staorder,tl.trseq, s.name  
from tblTrainLocation tl inner join tblLineStation ls on tl.lsseq=ls.seq
inner join tblStation s on ls.staseq=s.seq
where tl.trseq = 30 and to_char(tl.time,'yyyy-mm-dd') = '2020-07-16'
--where tl.trseq = %d and to_char(tl.time,'yyyy-mm-dd') = '2020-07-16
order by tl.seq desc;
--tnum

select tl.seq, to_char(tl.time,'yyyy-mm-dd-hh24-mi') as now, ls.staorder,tl.trseq, s.name 
from tblTrainLocation tl inner join tblLineStation ls on tl.lsseq=ls.seq
inner join tblStation s on ls.staseq=s.seq
where tl.trseq in (select seq from tblTrain where linerouteseq = 1) and ls.seq in (23,22,21) and to_char(tl.time,'yyyy-mm-dd') = '2020-07-16' 
order by tl.seq desc;

--고객의 즐겨찾기 목록 불러오기
select * from tblBookmark where cusseq = 100 and delflag=0;


