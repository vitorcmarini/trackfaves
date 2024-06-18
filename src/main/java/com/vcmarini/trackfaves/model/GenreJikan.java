package com.vcmarini.trackfaves.model;

public enum GenreJikan {
    ACTION("Action","Ação"),
    ADULT_CAST("Adult Cast", "Conteúdo Adulto"),
    ADVENTURE("Adventure","Aventura"),
    ANTHROPOMORPHIC("Anthropomorphic","Antropomórfico"),
    AVANT_GARDE("Avant Garde","Vanguarda"),
    AWARD_WINNING("Award Winning","Premiado"),
    BOYS_LOVE("Boys Love", "Amor Entre Garotos"),
    CGDCT("CGDCT", "Garotas Bonitas Fazendo Coisas Bonitas"),
    CHILDCARE("Childcare", "Cuidado Infantil"),
    COMEDY("Comedy", "Comédia"),
    COMBAT_SPORTS("Combat Sports", "Esportes de Combate"),
    CROSSDRESSING("Crossdressing", "Travestismo"),
    DELINQUENTS("Delinquents", "Delinquentes"),
    DETECTIVE("Detective", "Detetive"),
    DRAMA("Drama", "Drama"),
    ECCHI("Ecchi", "Ecchi"),
    EDUCATIONAL("Educational", "Educacional"),
    EROTICA("Erotica", "Erótica"),
    FANTASY("Fantasy", "Fantasia"),
    GAG_HUMOR("Gag Humor", "Humor de Esquetes"),
    GIRLS_LOVE("Girls Love", "Amor Entre Garotas"),
    GORE("Gore", "Gore"),
    GOURMET("Gourmet", "Gourmet"),
    HAREM("Harem", "Harém"),
    HIGH_STAKES_GAME("High Stakes Game", "Jogo de Alto Risco"),
    HISTORICAL("Historical", "Histórico"),
    HORROR("Horror", "Terror"),
    IDOLS_FEMALE("Idols (Female)", "Ídolos (Feminino)"),
    IDOLS_MALE("Idols (Male)", "Ídolos (Masculino)"),
    ISEKAI("Isekai", "Outro Mundo"),
    IYASHIKEI("Iyashikei", "Curativo"),
    JOSEI("Josei", "Josei"),
    KIDS("Kids", "Infantil"),
    LOVE_POLYGON("Love Polygon", "Polígono Amoroso"),
    MAGICAL_SEX_SHIFT("Magical Sex Shift", "Troca de Sexo Mágica"),
    MAHOU_SHOUJO("Mahou Shoujo", "Garota Mágica"),
    MARTIAL_ARTS("Martial Arts", "Artes Marciais"),
    MECHA("Mecha", "Mecha"),
    MEDICAL("Medical", "Médico"),
    MEMOIR("Memoir", "Memórias"),
    MILITARY("Military", "Militar"),
    MUSIC("Music", "Música"),
    MYSTERY("Mystery", "Mistério"),
    MYTHOLOGY("Mythology", "Mitologia"),
    ORGANIZED_CRIME("Organized Crime", "Crime Organizado"),
    OTAKU_CULTURE("Otaku Culture", "Cultura Otaku"),
    PARODY("Parody", "Paródia"),
    PERFORMING_ARTS("Performing Arts", "Artes Performáticas"),
    PETS("Pets", "Animais de Estimação"),
    PSYCHOLOGICAL("Psychological", "Psicológico"),
    RACING("Racing", "Corrida"),
    REINCARNATION("Reincarnation", "Reencarnação"),
    REVERSE_HAREM("Reverse Harem", "Harém Reverso"),
    ROMANCE("Romance", "Romance"),
    ROMANTIC_SUBTEXT("Romantic Subtext", "Subtexto Romântico"),
    SAMURAI("Samurai", "Samurai"),
    SCHOOL("School", "Escolar"),
    SCI_FI("Sci-Fi", "Ficção Científica"),
    SEINEN("Seinen", "Seinen"),
    SHOUJO("Shoujo", "Shoujo"),
    SHOUNEN("Shounen", "Shounen"),
    SHOWBIZ("Showbiz", "Showbiz"),
    SLICE_OF_LIFE("Slice of Life", "Slice of Life"),
    SPACE("Space", "Espaço"),
    SPORTS("Sports", "Esportes"),
    STRATEGY_GAME("Strategy Game", "Jogo de Estratégia"),
    SUPER_POWER("Super Power", "Super Poder"),
    SUPERNATURAL("Supernatural", "Sobrenatural"),
    SUSPENSE("Suspense", "Suspense"),
    SURVIVAL("Survival", "Sobrevivência"),
    TEAM_SPORTS("Team Sports", "Esportes em Equipe"),
    TIME_TRAVEL("Time Travel", "Viagem no Tempo"),
    VAMPIRE("Vampire", "Vampiro"),
    VIDEO_GAME("Video Game", "Video Game"),
    VILLAINESS("Villainess", "Vilã"),
    VISUAL_ARTS("Visual Arts", "Artes Visuais"),
    WORKPLACE("Workplace", "Ambiente de Trabalho");


    private String jikanGenre;
    private String trackfavesGenre;

    GenreJikan(String jikanGenre, String trackfavesGenre) {
        this.jikanGenre = jikanGenre;
        this.trackfavesGenre = trackfavesGenre;
    }

    public static GenreJikan fromJikanGenre(String jikanGenre) {
        for (GenreJikan gj : GenreJikan.values()) {
            if (gj.jikanGenre.equalsIgnoreCase(jikanGenre) ){
                return gj;
            }
        }
        throw new IllegalArgumentException("No equivalent gender found" + jikanGenre);
    }

    public static GenreJikan fromtrackfavesGenre(String trackfavesGenre) {
        for (GenreJikan gj : GenreJikan.values()) {
            if (gj.trackfavesGenre.equalsIgnoreCase(trackfavesGenre) ){
                return gj;
            }
        }
        throw new IllegalArgumentException("No equivalent gender found" + trackfavesGenre);
    }


}
