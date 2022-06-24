--Regular Expression Test
--실습에 필요한 T1 테이블 생성
@c:\db_test\sql_labs\regexp_tab.sql
SELECT * FROM t1;
--REGEXP_LIKE 실습
--fname이 Ste로 시작하고 중간에 v나 ph를 포함하고 en으로 끝나는 데이터 검색하기
SELECT fname, lname
FROM t1
WHERE REGEXP_LIKE (fname, '^Ste(v|ph)en$');
--전화번호의 형식이 XXX.XX.XXXX.XXXXXX 형식인 데이터 검색
SELECT fname, phone
FROM t1
WHERE REGEXP_LIKE (phone, '...\...\.....\.......') ;
--이전 예제를 숫자만 검색하도록 제한하기 
SELECT fname, phone
FROM t1
WHERE REGEXP_LIKE (phone, '[0-9]{3}\.[0-9]{2}\.[0-9]{4}\.[0-9]{6}');
--전화번호의 "." 으로 구분 된 문자를 "-" 으로 변경
SELECT fname, phone, REGEXP_REPLACE ( phone , '\.' , '-' ) new_format
FROM t1 ;
--전화번호의 형식이 숫자 3-3-4 인 데이터만 지역번호에 괄호를 하고 사이 문자를 "-"로 변경
SELECT fname, phone,
REGEXP_REPLACE (phone, '(\d{3})\.(\d{3})\.(\d{4})','(\1)-\2-\3') new_phone
FROM t1;
--REGEXP_INSTR 함수를 사용하여 주소와 전화번호에서 알파벳이 오는 첫 위치값을 반환
SELECT fname, addr, REGEXP_INSTR ( addr, '[[:alpha:]]' ) pos ,
       phone, REGEXP_INSTR ( phone, '[[:alpha:]]') pos
FROM t1;
--REGEXP_SUBSTR 함수를 사용하여 거리이름을 반환(공백과 공백 사이 공백이 아닌~)
SELECT fname, addr, REGEXP_SUBSTR ( addr, ' [^ ]+ ') road
FROM t1;
--RETEXP_SUBSTR 함수와 일반함수 REPLACE를 중첩하여 전화번호 가운데 국번만 출력
SELECT fname, phone,
       REPLACE(REGEXP_SUBSTR(phone,'\.(\d{3})\.'),'.') code
FROM t1;
--위 예제에서 REPLACE 함수를 쓰지 않은 경우의 결과와 비교
SELECT fname, phone,
      REGEXP_SUBSTR(phone,'\.(\d{3})\.') code
FROM t1;
--REGEXP_COUNT 함수를 사용하여 주소에 포함된 a의 개수 표시
SELECT fname, addr, REGEXP_COUNT(addr,'a') cnt
FROM t1;
--REGEXP_SUBSTR 함수 사용으로 서브표현식의 개념 알아보기
--인수의 의미(순서대로 시작위치-발생횟수,대소문자 식별여부, 하위식번호)
SELECT REGEXP_SUBSTR ('0123456789',
                      '(123)(4(56)(78))', 1, 1, 'i', 1 ) "Exp1" ,
       REGEXP_SUBSTR ('0123456789',
                      '(123)(4(56)(78))', 1, 1, 'i', 2 ) "Exp2" ,
       REGEXP_SUBSTR ('0123456789',
                      '(123)(4(56)(78))', 1, 1, 'i', 3 ) "Exp3" ,
       REGEXP_SUBSTR ('0123456789',
                      '(123)(4(56)(78))', 1, 1, 'i', 4 ) "Exp4"
FROM dual;
--REGEXP__INSTR 함수 사용으로 서브표현식의 시작위치 반환하기
--예제의 마지막 인수 "2"를 1~5로 바꿔가며 실행하고 결과비교하기
--인수의 의미(순서대로 시작위치-발생횟수,대소문자 식별여부,반환옵션(0 또는 1)  하위식번호)
SELECT REGEXP_INSTR ('0123456789',
                     '(123)(4(56)(78))', 1, 1, 0, 'i', 2 ) "Position"
FROM dual;
--REGEXP_INSTR 함수의 세 번째 인수인 반환옵션 실습
--두번째 서브표현식 45678의 다음인 9의 위치 반환
SELECT REGEXP_INSTR ('0123456789',
                     '(123)(4(56)(78))', 1, 1, 1, 'i', 2 ) "Position"
FROM dual;
--세번째 서브표현식 56의 다음인 7의 위치 반환
SELECT REGEXP_INSTR ('0123456789',
                     '(123)(4(56)(78))', 1, 1, 1, 'i', 3 ) "Position"
FROM dual;
--DNA 시퀀스 가운데 gtctcacaaag배열의 gtc 배열 찾기
SELECT REGEXP_INSTR('ccacctttccctccactcctcacgttctcacctgtaaagcgtccctc
cctcatccccatgcccccttaccctgcagggtagagtaggctagaaaccagagagctccaagc
tccatctgtggagaggtgccatccttgggctgcagagagaggagaatttgccccaaagctgcc
tgcagagcttcaccacccttagtctcacaaagccttgagttcatagcatttcttgagttttca
ccctgcccagcaggacactgcagcacccaaagggcttcccaggagtagggttgccctcaagag
gctcttgggtctgatggccacatcctggaattgttttcaagttgatggtcacagccctgaggc
atgtaggggcgtggggatgcgctctgctctgctctcctctcctgaacccctgaaccctctggc
taccccagagcacttagagccag',
'(gtc(tcac)(aaag))',
1, 1, 0, 'i',
1) "Position"
FROM dual;
--DNA 시퀀스 가운데 ccacctttccct배열의 ccct 배열 찾기
SELECT REGEXP_INSTR('ccacctttccctccactcctcacgttctcacctgtaaagcgtccctc
cctcatccccatgcccccttaccctgcagggtagagtaggctagaaaccagagagctccaagc
tccatctgtggagaggtgccatccttgggctgcagagagaggagaatttgccccaaagctgcc
tgcagagcttcaccacccttagtctcacaaagccttgagttcatagcatttcttgagttttca
ccctgcccagcaggacactgcagcacccaaagggcttcccaggagtagggttgccctcaagag
gctcttgggtctgatggccacatcctggaattgttttcaagttgatggtcacagccctgaggc
atgtaggggcgtggggatgcgctctgctctgctctcctctcctgaacccctgaaccctctggc
taccccagagcacttagagccag',
'(ccac(cttt)(ccct))',
1, 1, 0, 'i',
3) "Position"
FROM dual;
--REGEXP_COUNT 함수의 사용으로 소스에서 123 패턴의 발생 횟수 구하기
SELECT REGEXP_COUNT
('1234567812312378945123', '123') As Count
FROM dual;
--REGEXP_COUNT 함수의 사용으로 DNA 배열에서 gtc 패턴의 발생 횟수 구하기
SELECT REGEXP_COUNT(
'ccacctttccctccactcctcacgttctcacctgtaaagcgtccctccctcatccccatgcccccttaccctgcag
ggtagagtaggctagaaaccagagagctccaagctccatctgtggagaggtgccatccttgggctgcagagagaggag
aatttgccccaaagctgcctgcagagcttcaccacccttagtctcacaaagccttgagttcatagcatttcttgagtt
ttcaccctgcccagcaggacactgcagcacccaaagggcttcccaggagtagggttgccctcaagaggctcttgggtc
tgatggccacatcctggaattgttttcaagttgatggtcacagccctgaggcatgtaggggcgtggggatgcgctctg
ctctgctctcctctcctgaacccctgaaccctctggctaccccagagcacttagagccag',
'gtc') AS Count
FROM dual;
--다음 기사에서 Cloud 라는 문자 패턴은 몇번 나오는가?
SELECT REGEXP_COUNT('TikTok은 Oracle의 새로운 Generation 2 Cloud 구조가 현재 모든 타 주요 Cloud 제
공자가 제공하는 1세대 기술보다 더 빠르고 더 안정적이며 더욱 안전하기 때문에 이를
 선택했습니다."라며 Larry Ellison Oracle 기술 담당 최고 책임자는 말했습니다. "Oracle,
 Amazon Web Services, Microsoft, IBM 및 Google Cloud 등을 포함한 상위 IaaS 공급
업체에 대한 만족도를 Service(IaaS) 고객으로서 935개의 구조를 조사한 IDC가 최근 발
표한 2020년 Industry Cloud Path 조사에서 Oracle IaaS가 가장 높은 만족도 점수를 받
았습니다.
본 협정의 일부로 TikTok은 Oracle Cloud를 사용할 것이며 Oracle은 TikTok Global의
 소수 투자자가 될 것입니다,"라며 Safra Catz Oracle CEO는 전했습니다. "Oracle은 
TikTok 시스템을 Oracle Cloud 내에 빠르게 배치하고 신속하게 규모를 조정하고 운영
할 것입니다. 저희는 고도의 보안 환경을 TikTok에 제공하고 TikTok의 미국 사용자 및 
전 세계 사용자의 개인 정보를 보호하는 저희의 능력에 대해 100% 확신이 있습니다. 
엄청나게 향상된 보안 및 개인 정보 안전 보장을 통해 TikTok 사용자 커뮤니티의 지속
적이며 빠른 성장을 가능하게 하여 모든 주주에게 이점을 제공할 것입니다.
세계에서 가장 민감한 정보를 보호해온 몇십 년에 걸친 경험을 토대로 Oracle 
Generation 2 cloud 는 작동 중인 애플리케이션을 완벽하게 독립시키고 보안 위협요
소에 자체적으로 대응하기 위해 근본적으로 철저히 제작되었습니다. Oracle은 자체 보
안 Cloud 기술과 지속적인 코드 검사, 모니터링 및 감사를 결합하여 미국 TikTok 사
용자의 정보가 공개되지 않고 보호하는 데 전례 없는 보장을 제공할 것입니다.','Cloud') 
AS count
FROM dual
 
--"TikTok은 Oracle Cloud"문자열 속에 포함된 "Oracle" 단어의 위치 찾기
SELECT REGEXP_INSTR('TikTok은 Oracle의 새로운 Generation 2 Cloud 구조가 현재 모든 타 주요 Cloud 제
공자가 제공하는 1세대 기술보다 더 빠르고 더 안정적이며 더욱 안전하기 때문에 이를
 선택했습니다."라며 Larry Ellison Oracle 기술 담당 최고 책임자는 말했습니다. "Oracle,
 Amazon Web Services, Microsoft, IBM 및 Google Cloud 등을 포함한 상위 IaaS 공급
업체에 대한 만족도를 Service(IaaS) 고객으로서 935개의 구조를 조사한 IDC가 최근 발
표한 2020년 Industry Cloud Path 조사에서 Oracle IaaS가 가장 높은 만족도 점수를 받
았습니다.
본 협정의 일부로 TikTok은 Oracle Cloud를 사용할 것이며 Oracle은 TikTok Global의
 소수 투자자가 될 것입니다,"라며 Safra Catz Oracle CEO는 전했습니다. "Oracle은 
TikTok 시스템을 Oracle Cloud 내에 빠르게 배치하고 신속하게 규모를 조정하고 운영
할 것입니다. 저희는 고도의 보안 환경을 TikTok에 제공하고 TikTok의 미국 사용자 및 
전 세계 사용자의 개인 정보를 보호하는 저희의 능력에 대해 100% 확신이 있습니다. 
엄청나게 향상된 보안 및 개인 정보 안전 보장을 통해 TikTok 사용자 커뮤니티의 지속
적이며 빠른 성장을 가능하게 하여 모든 주주에게 이점을 제공할 것입니다.
세계에서 가장 민감한 정보를 보호해온 몇십 년에 걸친 경험을 토대로 Oracle 
Generation 2 cloud 는 작동 중인 애플리케이션을 완벽하게 독립시키고 보안 위협요
소에 자체적으로 대응하기 위해 근본적으로 철저히 제작되었습니다. Oracle은 자체 보
안 Cloud 기술과 지속적인 코드 검사, 모니터링 및 감사를 결합하여 미국 TikTok 사
용자의 정보가 공개되지 않고 보호하는 데 전례 없는 보장을 제공할 것입니다.',
'(TikTok은 (Oracle) (Cloud))', 
1, 1, 0, 'i',
2) "Position"
FROM dual;
