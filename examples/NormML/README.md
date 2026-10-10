# NormML trong USE

Build từ thư mục gốc bằng `mvn -pl goal -DisolatedPluginBuild package` (Java 21).
Plugin được chép vào `use/use-assembly/target/use-7.1.1/lib/plugins`.
Khởi động lại USE, chọn **Conformance of Processes and Goals → 6. Norm View Model**,
mở `examples/NormML/proposal-review.normml`. Có thể mở trong USE hoặc cửa sổ riêng.

Sơ đồ dùng DiagramView, ClassNode và BinaryAssociationOrLinkEdge của USE, giống cơ chế CSL.
Mỗi khai báo hiển thị dưới dạng class có ngăn thuộc tính; tiêu đề chỉ rõ loại norm/action.
Đây là mô hình UML phục vụ hiển thị, không thay đổi kiểu hay ngữ nghĩa khai báo NormML.
Kéo class/nhãn/đường nối và dùng menu chuột phải của USE để chỉnh bố cục.
Cây bên trái hiển thị đầy đủ thuộc tính và relation; tab Specification chứa nguồn.
Menu USE hỗ trợ Save/Load layout `.dlt`, căn chỉnh, lưới, bật/tắt attributes,
role names và multiplicities. Layout mặc định được đọc lại khi mở cùng file.
Giá trị thuộc tính đầy đủ (như condExpr, description) nằm trong cây khai báo;
ngăn thuộc tính của ClassNode hiển thị tên và kiểu UML phục vụ trình bày.

## Cú pháp

```text
normml Review {
  Organization office { }
  Role reviewer { organization: @office; resources: [@reviewProposal]; }
  Agent alice { plays: [@reviewer]; }
  AgentAction reviewProposal { actions: [@executeReview]; }
  AtomicAction executeReview { kind: AtomicExecute; }
  Norm mustReview { type: NormObligation; roles: [@reviewer]; access: [@executeReview]; }
}
```

`Role.resources` khai báo hành vi/tài nguyên của role. `Agent.plays` xác định agent
đóng role đó: không cần lặp lại resource ở agent hoặc organization. Chỉ khai báo
`Agent.resources` khi muốn biểu diễn tài nguyên gán trực tiếp cho cá nhân;
`Organization.resources` khi muốn biểu diễn tài nguyên gán trực tiếp cho tổ chức.
Compiler không sao chép các liên kết này và không suy ra quyền truy cập từ chúng.

Trong ví dụ mẫu, `reviewProposal : AgentAction` là hành vi nghiệp vụ;
`executeReview : AtomicAction` với `kind: AtomicExecute` là thao tác thực hiện nó.
Norm gắn với reviewer và executeReview. `After.afterActions` trỏ tới executeSubmit,
nghĩa là nghĩa vụ được kích hoạt sau hành động nộp bài. Ví dụ có đủ ba norm: `review` (Obligation), `readPermission` (Permission)
và `noChangeAfterSubmission` (Prohibition).
`AttributeResource` chỉ dùng khi cần điều chỉnh đọc/ghi thuộc tính cụ thể.
Đây là cách biểu diễn bằng các concept hiện có, không cần thêm class hoặc alias.

Hình tham khảo còn phân biệt role sẽ thực hiện/đã thực hiện action và context của
norm. Profile hiện tại chưa biểu diễn riêng những liên kết occurrence đó; `resources`
không khẳng định một action đã xảy ra. Ví dụ cũng chưa quy định deadline để bộ thực
thi xác định thời điểm vi phạm và phát sinh sanction.


Mỗi khai báo có dạng `Class identifier { feature: value; }`. Tuy nhiên `Class`,
`feature` và các enum không phải identifier tự do: `NormML.g4` có rule ANTLR riêng
cho từng EClass concrete và từng feature hợp lệ trong `docs/model/normml.ecore`.
ANTLR sinh `NormMLLexer` và `NormMLParser` trong pha `generate-sources`; không sửa
các file Java sinh ra trong `target-maven/generated-sources/antlr4` bằng tay.
Metamodel được đóng gói vào plugin để resolve kiểu, opposite, containment,
multiplicity và invariant sau khi parser đã kiểm tra concrete syntax.
Identifier phải duy nhất trong file. `@id` chỉ liên kết nội bộ; collection dùng
`[@id1, @id2]`. Chuỗi dùng dấu ngoặc kép, hỗ trợ `\n`, `\r`, `\t`, `\"`, `\\`.
Comment dùng `//` hoặc `/* ... */`. Cho phép tham chiếu tới khai báo phía sau.

`NormModel` được tạo từ khai báo `normml`; các containment cấp root và `model`
được suy ra tự động. `name` mặc định là identifier. Với quan hệ hai chiều,
chỉ cần khai báo một chiều: `Resource.actions` tự đặt `Action.resource`,
`Role.organization` tự thêm role vào `Organization.roles`. Các đối tượng con
(Action, Role, Condition, NormConstraint) phải có đúng một containment owner.
Các class abstract không được khởi tạo trực tiếp. Mỗi Condition thuộc riêng
một If hoặc Action; không chia sẻ cùng instance giữa hai containment owner.

Compiler kiểm tra cú pháp, định danh, loại reference, multiplicity, containment,
enum, chủ thể norm, chu trình, action/resource và các boundary thời gian theo
profile Ecore. OCL được kiểm tra **cú pháp** bằng parser của USE; chưa kiểm tra
kiểu, Boolean result hay đánh giá trên CSL state. Hiện chỉ hỗ trợ `condLang: OCL`.
Không tham chiếu hoặc nạp metamodel CSL, iStar, BPMN; không thay đổi USE session.
Plugin này biên dịch và xem mô hình, chưa thực thi norm hoặc phát thưởng/phạt.

API: `NormCompiler.compile(Path)` hoặc `compile(String)` trả về AST, mô hình đã
resolve liên kết và danh sách lỗi có tên file/dòng/cột. Nếu lỗi, model là null.
Entry point headless: `org.vnu.sme.goal.dsl.normml.parser.NormCompiler <file.normml>`
(chạy với plugin jar và thư viện USE trên classpath).
