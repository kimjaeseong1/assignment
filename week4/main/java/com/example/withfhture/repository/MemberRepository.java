package com.example.withfhture.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {

    Optional<Member> findByMemberId(UUID memberId);

    Optional<Member> deleteByMemberId(UUID memberId);
}
