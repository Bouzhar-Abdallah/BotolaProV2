package Bouzhar.BotolaPro.demo.seeders;

import Bouzhar.BotolaPro.demo.entity.Club;
import Bouzhar.BotolaPro.demo.repository.ClubRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class ClubSeeder implements CommandLineRunner {

    private final ClubRepository clubRepository;

    public ClubSeeder(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        if (clubRepository.count() == 0) {
            //clubs with names and icon_logo_url = '';

            String green = "#00FF00";
            String blue = "#0000FF";
            String red = "#FF0000";
            String yellow = "#FFFF00";
            String black = "#000000";
            String white = "#FFFFFF";
            String orange = "#FFA500";
/*
            'name' => 'FAR Rabat',
                    'shortName' => 'FAR',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/lxzYYTil-EyoH1qCf_l4qv6o.png',
                    'primaryColor' => $red,
                    'secondaryColor' => $green,
            ], [
            'name' => 'Wydad Casablanca',
                    'shortName' => 'WAC',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/GI8EoU9r-jwS3BZqq_p8fshg.png',
                    'primaryColor' => $red,
                    'secondaryColor' => $white,
            ], [
            'name' => 'FUS Rabat',
                    'shortName' => 'FUS',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558534/EkvitHfM-W6bUbbPE_uy1ix2.png',
                    'primaryColor' => $white,
                    'secondaryColor' => $red,
            ], [
            'name' => 'Raja Casablanca',
                    'shortName' => 'RCA',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/ATfrBYjl-MPQ5rYxJ_vva1yd.png',
                    'primaryColor' => $green,
                    'secondaryColor' => $white,
            ], [
            'name' => 'Olympyque Safi',
                    'shortName' => 'OCS',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/UJFjZFBr-63LcsWgs_rjvpxb.png',
                    'primaryColor' => $blue,
                    'secondaryColor' => $red,
            ], [
            'name' => 'Berkane',
                    'shortName' => 'RSB',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/UPmgHwCa-bqNV2HgA_qp3vdo.png',
                    'primaryColor' => $orange,
                    'secondaryColor' => $green,
            ], [
            'name' => 'Maghreb Fez',
                    'shortName' => 'MAS',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/WYYLJbyS-KrkUCdS2_e2kq5a.png',
                    'primaryColor' => $yellow,
                    'secondaryColor' => $black,
            ], [
            'name' => 'Union Touarga',
                    'shortName' => 'UTS',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/bkYK1GyB-prhXSujC_g1bafs.png',
                    'primaryColor' => $yellow,
                    'secondaryColor' => $green,
            ], [
            'name' => 'Jeunesse Sportive Soualem',
                    'shortName' => 'JSS',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/4p46iqZA-8WZfae8O_ilfyfd.png',
                    'primaryColor' => $blue,
                    'secondaryColor' => $yellow,
            ], [
            'name' => 'Chabab Mohammedia',
                    'shortName' => 'SCCM',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/jZUCPOzB-QgRSIkyp_srixvp.png',
                    'primaryColor' => $red,
                    'secondaryColor' => $black,
            ], [
            'name' => 'Moghreb Tetouan',
                    'shortName' => 'MAT',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/fTN1kBBr-bZmYBGs9_v8xmjp.png',
                    'primaryColor' => $red,
                    'secondaryColor' => $white
            ], [
            'name' => 'Difaa El Jadidi',
                    'shortName' => 'DHJ',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/jq7lbJjl-W6bUbbPE_tnbm2w.png',
                    'primaryColor' => $green,
                    'secondaryColor' => $white,
            ], [
            'name' => 'Mouloudia Oujda',
                    'shortName' => 'MCO',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/jJr8Z9zS-xpXGXQAn_kbe2r0.png',
                    'primaryColor' => $green,
                    'secondaryColor' => $white,
            ], [
            'name' => 'Hassania Agadir',
                    'shortName' => 'HUSA',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/hA0ehAzB-63LcsWgs_ucshay.png',
                    'primaryColor' => $red,
                    'secondaryColor' => $white,
            ], [
            'name' => 'Olympyque Khouribga',
                    'shortName' => 'OCK',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/bc8qdozB-j7JNl0QM_zjz4t3.png',
                    'primaryColor' => $green,
                    'secondaryColor' => $white,
            ], [
            'name' => 'Itihad Tanger',
                    'shortName' => 'IRT',
                    'logoUrl' => 'https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/lr4B35Cr-bqNV2HgA_i9avvv.png',
                    'primaryColor' => $blue,
                    'secondaryColor' => $white,
            ],*/
            clubRepository.save(new Club("FAR Rabat", "FAR", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/lxzYYTil-EyoH1qCf_l4qv6o.png", red, green, white));
            clubRepository.save(new Club("Wydad Casablanca", "WAC", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/GI8EoU9r-jwS3BZqq_p8fshg.png", red, white, white));
            clubRepository.save(new Club("FUS Rabat", "FUS", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558534/EkvitHfM-W6bUbbPE_uy1ix2.png", white, red, white));
            clubRepository.save(new Club("Raja Casablanca", "RCA", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/ATfrBYjl-MPQ5rYxJ_vva1yd.png", green, white, white));
            clubRepository.save(new Club("Olympyque Safi", "OCS", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/UJFjZFBr-63LcsWgs_rjvpxb.png", blue, red, white));
            clubRepository.save(new Club("Berkane", "RSB", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/UPmgHwCa-bqNV2HgA_qp3vdo.png", orange, green, white));
            clubRepository.save(new Club("Maghreb Fez", "MAS", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/WYYLJbyS-KrkUCdS2_e2kq5a.png", yellow, black, white));
            clubRepository.save(new Club("Union Touarga ", "UTS", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/bkYK1GyB-prhXSujC_g1bafs.png", yellow, green, white));
            clubRepository.save(new Club("Jeunesse Sportive Soualem", "JSS", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/4p46iqZA-8WZfae8O_ilfyfd.png", blue, yellow, white));
            clubRepository.save(new Club("Chabab Mohammedia", "SCCM", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/jZUCPOzB-QgRSIkyp_srixvp.png", red, black, white));
            clubRepository.save(new Club("Moghreb Tetouan", "MAT", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/fTN1kBBr-bZmYBGs9_v8xmjp.png", red, white, white));
            clubRepository.save(new Club("Difaa El Jadidi", "DHJ", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/jq7lbJjl-W6bUbbPE_tnbm2w.png", green, white, white));
            clubRepository.save(new Club("Mouloudia Oujda", "MCO", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/jJr8Z9zS-xpXGXQAn_kbe2r0.png", green, white, white));
            clubRepository.save(new Club("Hassania Agadir", "HUSA", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/hA0ehAzB-63LcsWgs_ucshay.png", red, white, white));
            clubRepository.save(new Club("Olympyque Khouribga", "OCK", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558535/bc8qdozB-j7JNl0QM_zjz4t3.png", green, white, white));
            clubRepository.save(new Club("Itihad Tanger", "IRT", "https://res.cloudinary.com/doy8hfzvk/image/upload/v1680558536/lr4B35Cr-bqNV2HgA_i9avvv.png", blue, white, white));

        }
    }
}
