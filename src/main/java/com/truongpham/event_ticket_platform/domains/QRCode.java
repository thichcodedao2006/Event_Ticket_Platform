package com.truongpham.event_ticket_platform.domains;

import com.truongpham.event_ticket_platform.enums.QRCodeStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Table (name = "qr_codes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QRCode {

    @Id
    @Column (name =  "id", updatable = false, nullable = false)
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "value", nullable = false)
    private String value; // gia tri cua qr_code

    @Column (name = "status", nullable = false)
    @Enumerated (EnumType.STRING)
    private QRCodeStatusEnum status;

    @ManyToOne (fetch =  FetchType.LAZY)
    @JoinColumn (name = "ticket_id")
    private Ticket ticket;

    @CreatedDate
    @Column (name =  "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column (name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QRCode qrCode = (QRCode) o;
        return Objects.equals(id, qrCode.id) && Objects.equals(value, qrCode.value) && status == qrCode.status && Objects.equals(createdAt, qrCode.createdAt) && Objects.equals(updatedAt, qrCode.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, status, createdAt, updatedAt);
    }
}
