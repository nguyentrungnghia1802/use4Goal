# Giải thích concept và relation của NormML

## NormModel

`NormModel` là root lưu tài liệu, bổ sung kỹ thuật của profile Ecore; không mang ngữ nghĩa `Environment`. NormML, iStar, BPMN và CSL là bốn metamodel độc lập. Không có reference từ NormML sang classifier của ba metamodel kia. `name` đặt tên tài liệu.

| Relation | Vì sao tồn tại |
|---|---|
| `norms ↔ Norm.model` | Chứa các quy định; mỗi norm thuộc một tài liệu. |
| `resources ↔ Resource.model` | Chứa các khai báo tài nguyên dùng chung trong tài liệu. |
| `sanctions ↔ Sanction.model` | Chứa hậu quả để nhiều norm cùng sử dụng. |
| `dates ↔ Date.model` | Sở hữu các mốc ngày, cho phép constraint liên kết tới chúng bằng association. |
| `organizations ↔ Organization.model` | Sở hữu các tổ chức được khai báo trong góc nhìn normative. |
| `agents ↔ Agent.model` | Sở hữu các chủ thể cá nhân được quy định điều chỉnh. |
| `dataTypes ↔ DataType.model` | Sở hữu các khai báo kiểu nội bộ dùng chung. |

Các collection trên có multiplicity `0..*`, containment; chiều `model` là `1`. Đây là lựa chọn lưu trữ của dự án, không phải các quan hệ nghiệp vụ mới.

## Organization, Agent và Role

Ba concept giữ vai trò chủ thể trong sơ đồ NormML đã cung cấp: tổ chức, tác tử và vai trò. Chúng là khai báo nội bộ NormML. Thuộc tính `name` giúp nhận diện khai báo. Không có `AgentRole`.

| Relation | Vì sao tồn tại |
|---|---|
| `Organization.subOrganizations ↔ parent` | Biểu diễn phân cấp tổ chức; nhiều tổ chức con, tối đa một cha. Là association vì root đã sở hữu các tổ chức. Không cho phép chu trình. |
| `Organization.roles ↔ Role.organization` | Một tổ chức chứa các vai trò; mỗi vai trò thuộc một tổ chức. |
| `Agent.plays ↔ Role.players` | Nối trực tiếp tác tử với vai trò mà nó đóng, nhiều–nhiều; không cần lớp trung gian. |
| `Organization.norms ↔ Norm.organizations` | Xác định quy định áp dụng cho tổ chức. |
| `Agent.norms ↔ Norm.agents` | Xác định quy định áp dụng trực tiếp cho tác tử. |
| `Role.norms ↔ Norm.roles` | Xác định quy định áp dụng theo vai trò. |

`Agent.resources`, `Role.resources`, `Organization.resources → Resource [0..*]` xác định tài nguyên mà từng chủ thể có. Đây là ba association trực tiếp, bổ sung theo phương pháp của dự án; không thêm lớp trung gian. Resource vẫn được lưu ở NormModel để nhiều chủ thể có thể cùng liên kết. Có resource không tự cấp quyền thao tác: quyền, nghĩa vụ hoặc cấm do Norm xác định. Các liên kết này chỉ trỏ tới resource trong cùng tài liệu; không tự suy diễn quyền từ phân cấp tổ chức hoặc vai trò. Không cần khai báo cùng resource ở cả ba cấp. Khi norm áp dụng theo Role, khai báo resource ở Role và dùng Agent.plays để chỉ người đóng vai trò; Agent.resources chỉ diễn tả gán trực tiếp cho cá nhân, Organization.resources chỉ diễn tả gán trực tiếp cho tổ chức. Với hành vi nghiệp vụ như hình mẫu, Role.resources trỏ tới AgentAction, Resource.actions chứa AtomicAction có kind AtomicExecute và Norm.access trỏ tới thao tác đó. Quan hệ này không thay cho thông tin ai đã thực hiện action trong một lần chạy.

Tên giống nhau giữa hai mô hình không tự tạo liên kết hay chứng minh hai chủ thể là một.

## Norm và NormType

`Norm` biểu diễn quy định. `NormType` phân biệt `NormObligation`, `NormPermission`, `NormProhibition`: phải làm, được làm, bị cấm làm. Ba ngữ nghĩa là nền tảng deontic của NormML; mã hóa bằng enum là lựa chọn của dự án. `name` phục vụ nhận diện và phải duy nhất trong tài liệu; `type` mặc định nghĩa vụ.

| Relation | Vì sao tồn tại |
|---|---|
| `roles`, `agents`, `organizations [0..*]` | Chọn các chủ thể nội bộ chịu quy định; ít nhất một trong ba tập phải khác rỗng. |
| `access ↔ Action.norms` | Chọn `1..*` thao tác chịu điều chỉnh; một thao tác có thể được nhiều norm sử dụng. |
| `constraints ↔ NormConstraint.norm` | Chứa `0..*` điều kiện kích hoạt; mỗi constraint thuộc một norm. |
| `sanctions ↔ Sanction.sanctionedNorms` | Chọn hậu quả phát sinh từ kết quả tuân thủ/vi phạm norm này. |
| `activatedBy ↔ Sanction.activatedNorms` | Chỉ hậu quả nào có thể kích hoạt norm này. Khác với norm nguồn gây ra hậu quả. |

## Resource và DataType

`Resource` abstract biểu diễn đối tượng của thao tác theo hình Action–Resource người dùng cung cấp. `name` nhận diện tài nguyên. Các lớp con phân biệt đối tượng để kiểm tra loại thao tác phù hợp; hậu tố `Resource` là cách đặt tên của profile.

| Concept hoặc relation | Vì sao tồn tại |
|---|---|
| `EntityResource extends Resource` | Đối tượng được tạo, đọc, cập nhật hoặc xóa. |
| `AttributeResource extends Resource` | Thuộc tính được đọc hoặc cập nhật. |
| `AssociationEndResource extends Resource` | Đầu liên kết mà thao tác truy cập điều chỉnh. |
| `AgentAction extends Resource` | Hành vi của tác tử được thực hiện bằng `AtomicExecute`, theo concept trong hình gốc. |
| `MessageResource extends Resource` | Thông điệp được gửi hoặc nhận. |
| `Resource.actions ↔ Action.resource` | Resource chứa `1..*` thao tác; mỗi thao tác tác động lên đúng một resource. Containment là lựa chọn Ecore. |
| `DataType` | Bổ sung của dự án để khai báo kiểu dữ liệu nội bộ; `name` đặt tên kiểu. Không phải reference tới CSL.DataType. |
| `AttributeResource.dataType → DataType [1]` | Khai báo kiểu giá trị của thuộc tính. |
| `MessageResource.dataType → DataType [0..1]` | Khai báo kiểu payload khi thông điệp có dữ liệu cần định kiểu. |

Các khai báo này không chứa giá trị trạng thái CSL và không tự định nghĩa bộ kiểm tra kiểu OCL. Profile chưa mô hình hóa riêng `Method`, `Protocol` và các quan hệ sở hữu domain trong hình gốc; không coi đây là bản sao đầy đủ của hình đó.

## Action, AtomicAction và CompositeAction

`Action` abstract tách thao tác truy cập khỏi resource. `AtomicAction` và `CompositeAction` kế thừa Action theo hình NormML được cung cấp. Thuộc tính `kind` dùng enum thay các lớp con rỗng; đây là cách mã hóa của dự án.

| Concept hoặc giá trị | Vì sao tồn tại |
|---|---|
| `AtomicAction` | Biểu diễn một loại thao tác nguyên tử. |
| `AtomicActionKind.AtomicCreate` | Tạo đối tượng hoặc liên kết. |
| `AtomicRead` | Đọc đối tượng, thuộc tính hoặc liên kết. |
| `AtomicUpdate` | Cập nhật đối tượng, thuộc tính hoặc liên kết. |
| `AtomicDelete` | Xóa đối tượng hoặc liên kết. |
| `AtomicExecute` | Thực hiện AgentAction. |
| `AtomicSend`, `AtomicReceive` | Gửi và nhận MessageResource. |
| `CompositeAction` | Gom các khả năng truy cập thành một nhóm được quy định điều chỉnh. |
| `CompositeActionKind.EntityRead`, `EntityUpdate` | Gom quyền đọc hoặc cập nhật liên quan đến entity. |
| `EntityFullAccess` | Gom quyền truy cập đầy đủ được khai báo cho entity. |
| `AttributeFullAccess` | Gom quyền đối với thuộc tính. |
| `AssociationEndFullAccess` | Gom quyền đối với đầu liên kết. |
| `MessageFullAccess` | Gom quyền đối với thông điệp. |
| `CompositeAction.subordinateActions → Action [1..*]` | Biểu diễn ActionHierarchy: nhóm tham chiếu các thao tác thành phần, có thể lồng nhau nhưng không có chu trình. Là association để tái sử dụng thành phần. |

Các giá trị enum lấy tên từ hình đã cung cấp. Bảng tương thích action–resource là quy tắc profile. `FullAccess` không tự sinh các thao tác thành phần; phải khai báo chúng. CompositeAction không biểu diễn thứ tự control flow của BPMN.

## NormConstraint, Before, After, Between và Date

`NormConstraint` abstract biểu diễn điều kiện kích hoạt chung. `Before`, `After`, `Between`, `If` kế thừa nó để phân biệt điều kiện thời gian/hành động với điều kiện trạng thái, theo nhóm activation constraints của NormML.

| Concept hoặc relation | Vì sao tồn tại |
|---|---|
| `NormConstraint.norm [1]` | Điều hướng tới norm sở hữu constraint. |
| `NormConstraint.dates → Date [0..*]` | Liên kết thông thường tới mốc ngày, đúng lựa chọn association của mô hình. Không containment. |
| `Date.value : EDate [1]` | Lưu mốc thời gian tuyệt đối bằng datatype chuẩn EMF. |
| `Before.beforeActions → Action [0..*]` | Mốc hành động mà điều kiện có hiệu lực trước đó. Before cần action hoặc date. |
| `After.afterActions → Action [0..*]` | Mốc hành động mà điều kiện có hiệu lực sau đó. After cần action hoặc date. |
| `Between.afterActions → Action [0..*]` | Các mốc hành động mở khoảng hiệu lực. |
| `Between.beforeActions → Action [0..*]` | Các mốc hành động đóng khoảng hiệu lực. |
| `Between.startDate → Date [0..1]` | Bổ sung của profile để chỉ rõ ngày mở khoảng trong tập dates. |
| `Between.endDate → Date [0..1]` | Chỉ rõ ngày đóng khoảng trong tập dates, khác đối tượng startDate. |

Mỗi phía của Between cần action hoặc date. Các reference ngày phân biệt vai trò hai đầu; kiểm tra thứ tự giá trị ngày và occurrence của action cần ngữ nghĩa thực thi riêng.

## If và Condition

`If` biểu diễn guard theo trạng thái. `Condition` là **mở rộng của dự án theo yêu cầu**, không khẳng định là lớp có sẵn trong NormML gốc. Tách lớp này để cùng một cấu trúc biểu thức được dùng cho If và Action, không phải sao chép các thuộc tính OCL vào hai lớp.

| Relation hoặc thuộc tính | Vì sao tồn tại |
|---|---|
| `Action.condition → Condition [0..1]` | Điều kiện trạng thái bổ nghĩa cho action; AtomicAction và CompositeAction đều kế thừa. Containment vì biểu thức thuộc action này. Tùy chọn vì action có thể không có điều kiện. |
| `If.condition → Condition [1]` | If chứa đúng một biểu thức điều kiện; containment vì biểu thức thuộc guard này. |
| `Condition.condExpr : EString [1]` | Lưu phần thân predicate OCL, ví dụ `self.proposal.currentRevision = self.proposal.validationRevision`. |
| `Condition.condLang : EString [1] = OCL` | Chỉ ngôn ngữ diễn giải biểu thức. |

`If.condition` quyết định khi nào norm được kích hoạt; `Action.condition` xác định điều kiện trạng thái gắn với thao tác mà norm điều chỉnh. Đây là lựa chọn của profile, không phải lớp hay quan hệ được khẳng định có sẵn trong nguồn NormML. Action.condition không mô tả kết quả sau action và không tự chặn hành vi vi phạm. Mỗi nơi sở hữu một đối tượng Condition riêng, dùng chung kiểu biểu diễn.

`If` không sử dụng dates; điều kiện thời gian dùng ba lớp tương ứng. Condition không có reference tới CSL, iStar, BPMN hay danh sách attribute ngoài mô hình. Khi đánh giá, bộ thực thi cung cấp trạng thái CSL và đối tượng gắn với `self`; biểu thức cần trả về Boolean. Ecore chỉ lưu biểu thức và kiểm tra chuỗi không rỗng, chưa biên dịch hay thực thi OCL trong `condExpr`. Quy ước kết hợp nhiều guard cần được xác định ở bộ thực thi.

## Sanction và SanctionType

`Sanction` biểu diễn hậu quả của tuân thủ/vi phạm. `SanctionType` phân biệt `Punishment` và `Reward`. Hai ý nghĩa thuộc mô hình normative; dùng enum với mặc định Punishment là lựa chọn Ecore. `description` ghi mô tả tùy chọn.

| Relation | Vì sao tồn tại |
|---|---|
| `sanctionedNorms → Norm [1..*]` | Chọn norm nguồn mà kết quả làm phát sinh hậu quả. |
| `activatedNorms → Norm [0..*]` | Chọn norm đích được kích hoạt bởi hậu quả. |

Hai quan hệ phân biệt nguyên nhân và kết quả. Chúng không tự xác định người nhận thưởng/phạt hay thời điểm nghĩa vụ bị vi phạm.
