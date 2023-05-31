package gesia.gesiabackend.modules.common;

public class Const {

    /**
     * 공통
     */
    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "성공";

    public static final int FAIL = 1;
    public static final String FAIL_MSG = "실패";

    /**
     * Exception
     * 명명 규칙
     * - Domain을 접두사로 붙인다.
     */
    public static final String ACCOUNT_NOT_FOUND_ACCOUNT = "계정을 찾을 수 없습니다.";
    public static final String ACCOUNT_EXPIRED_CODE_OR_INCORRECT_CODE = "만료 되었거나 일치하지 않는 인증 코드입니다.";
    public static final String ACCOUNT_INCORRECT_PASSWORD = "비밀번호가 일치하지 않습니다.";
    public static final String ACCOUNT_USED_EMAIL = "사용중인 이메일입니다.";
    public static final String ACCOUNT_INVALID_EMAIL_FORMAT = "올바르지 않은 이메일 양식입니다.";
    public static final String ACCOUNT_USED_ACCOUNT_BY_BUSINESS_NUMBER = "당사의 정책에 따라 하나의 사업자번호에 대해서는 중복 가입이 불가합니다.";
    public static final String ACCOUNT_WITHDRAWAL_ACCOUNT = "탈퇴한 회원입니다.";

    public static final String ACCOUNT_DTO_NO_RECEIVER = "수신받을 이메일을 입력해주세요.";
    public static final String ACCOUNT_DTO_NO_USERNAME = "아이디를 입력해주세요.";
    public static final String ACCOUNT_DTO_NO_PASSWORD = "비밀번호를 입력해주세요.";
    public static final String ACCOUNT_DTO_NO_NEW_PASSWORD = "변경할 비밀번호를 입력해주세요.";
    public static final String ACCOUNT_DTO_NO_ACCOUNT_TYPE = "회원 종류를 체크해주세요.";
    public static final String ACCOUNT_DTO_WRONG_PASSWORD_RULE = "비밀번호는 길이가 8에서 20 사이여야 합니다.";
    public static final String ACCOUNT_DTO_NO_BANK_INFO = "은행 정보는 필수로 입력해야 하는 값입니다.";
    public static final String ACCOUNT_DTO_NO_BUSINESS_NUMBER = "사업자등록번호를 입력해주세요.";
    public static final String ACCOUNT_DTO_NO_ACCOUNT_DETAILS = "회원 상세 정보는 필수로 입력해야 하는 값입니다.";

    public static final String JWT_UNAUTHENTICATED_USER = "접근 권한이 없습니다.";
    public static final String JWT_WITHOUT_ACCESS = "인증되지 않은 사용자입니다.";

    public static final String CERTIFICATION_EDITING_DISABLED = "신청한 인증서를 확인중으로 수정이 불가합니다.";
    public static final String CERTIFICATION_NOT_FOUND_BY_ID = "해당하는 값이 비어있습니다.";
    public static final String CERTIFICATION_ACCOUNT_NOT_FOUND = "해당 아이디가 없습니다.";
    public static final String CERTIFICATION_NOT_FOUND_ACCOUNT_BY_CERT = "해당 계정과 일치하는 인증서가 없습니다.";

    public static final String CERTIFICATION_NFV_NOT_FOUND = "NFV 내역이 없습니다.";
    public static final String CERTIFICATION_NFT_NOT_FOUND = "NFT 내역이 없습니다.";

    public static final String NFT_MARKET_TYPE_NOT_FOUND = "판매중인 NFT가 아닙니다.";
    public static final String NFT_MARKET_NOT_PURCHASE_HISTORY = "NFT 구매 내역이 없습니다.";
    public static final String NFT_MARKET_NOT_FOUND_BY_ID = "지정된 ID에 대한 내역을 찾을 수 없습니다.";
    public static final String NFT_MARKET_REGISTERED_FOR_SALE = "판매중인 NFT 입니다.";
}
