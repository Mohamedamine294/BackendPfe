package com.projectPFE.demo.services;

import com.projectPFE.demo.dto.request.LoginRequest;
import com.projectPFE.demo.dto.request.RegisterRequest;
import com.projectPFE.demo.dto.response.AuthResponse;
import com.projectPFE.demo.entities.Administrateur;
import com.projectPFE.demo.entities.EtudiantBaccalaureat;
import com.projectPFE.demo.entities.EtudiantLicence;
import com.projectPFE.demo.entities.Entreprise;
import com.projectPFE.demo.entities.Utilisateur;
import com.projectPFE.demo.enums.Role;
import com.projectPFE.demo.repositories.AdministrateurRepository;
import com.projectPFE.demo.repositories.EntrepriseRepository;
import com.projectPFE.demo.repositories.EtudiantBaccalaureatRepository;
import com.projectPFE.demo.repositories.EtudiantLicenceRepository;
import com.projectPFE.demo.repositories.UtilisateurRepository;
import com.projectPFE.demo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final EtudiantBaccalaureatRepository etudiantBacRepository;
    private final EtudiantLicenceRepository etudiantLicenceRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final AdministrateurRepository administrateurRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {

        // Check if email already exists
        if (utilisateurRepository.existsByEmail(
                request.getEmail())) {
            throw new RuntimeException(
                    "Email déjà utilisé!");
        }

        // Create Utilisateur
        Utilisateur utilisateur = Utilisateur.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .motDePasse(passwordEncoder.encode(
                        request.getMotDePasse()))
                .role(request.getRole())
                .estActif(true)
                .build();

        utilisateurRepository.save(utilisateur);

        // Create profile based on role
        if (request.getRole() == Role.ETUDIANT_BAC) {
            EtudiantBaccalaureat etudiant =
                    EtudiantBaccalaureat.builder()
                            .utilisateur(utilisateur)
                            .build();
            etudiantBacRepository.save(etudiant);

        } else if (request.getRole() ==
                Role.ETUDIANT_LICENCE) {
            EtudiantLicence etudiant =
                    EtudiantLicence.builder()
                            .utilisateur(utilisateur)
                            .build();
            etudiantLicenceRepository.save(etudiant);

        } else if (request.getRole() ==
                Role.ENTREPRISE) {
            Entreprise entreprise =
                    Entreprise.builder()
                            .utilisateur(utilisateur)
                            .nomEntreprise(request.getNom())
                            .estValidee(false)
                            .build();
            entrepriseRepository.save(entreprise);

        } else if (request.getRole() ==
                Role.ADMINISTRATEUR) {
            Administrateur admin =
                    Administrateur.builder()
                            .utilisateur(utilisateur)
                            .nom(request.getNom())
                            .email(request.getEmail())
                            .build();
            administrateurRepository.save(admin);
        }

        // Generate JWT token
        String token = jwtService.generateToken(
                utilisateur);

        return AuthResponse.builder()
                .token(token)
                .userId(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .role(utilisateur.getRole())
                .build();
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotDePasse()
                )
        );

        Utilisateur utilisateur =
                utilisateurRepository
                        .findByEmail(request.getEmail())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Utilisateur non trouvé"));

        String token = jwtService.generateToken(
                utilisateur);

        return AuthResponse.builder()
                .token(token)
                .userId(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .role(utilisateur.getRole())
                .build();
    }
}