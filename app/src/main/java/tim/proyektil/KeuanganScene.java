package tim.proyektil;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class KeuanganScene extends BaseScene {

    public KeuanganScene(Stage primaryStage, Scene mainScene) {
        super(primaryStage, mainScene);
    }

    @Override
    public Scene getScene() {
        String textContent = "Bidang keuangan dan akuntansi menawarkan berbagai peluang karir yang menarik dan bermanfaat. Lulusan dengan latar belakang keuangan dan akuntansi memiliki banyak pilihan untuk bekerja di berbagai industri.\n\nBerikut beberapa informasi mengenai karir di bidang keuangan dan akuntansi:\n\nJenis-jenis Pekerjaan Keuangan dan Akuntansi:\n\nAda banyak jenis pekerjaan di bidang keuangan dan akuntansi yang tersedia, dengan berbagai fokus dan tanggung jawab. Beberapa contohnya:\n\n- Analis Keuangan: Menganalisis kondisi keuangan perusahaan dan memberikan rekomendasi.\n- Manajer Keuangan: Mengelola keuangan perusahaan dan membuat perencanaan keuangan.\n- Akuntan: Mencatat, mengelola, dan melaporkan transaksi keuangan.\n- Auditor: Memeriksa catatan keuangan perusahaan untuk memastikan keakuratan dan kepatuhan.\n- Konsultan Pajak: Memberikan nasihat tentang perencanaan pajak dan kepatuhan pajak.\n- Analis Investasi: Menganalisis peluang investasi dan memberikan rekomendasi.\n- Spesialis Kredit: Mengevaluasi kelayakan kredit dan mengelola risiko kredit.\n- Bendahara: Mengelola arus kas dan investasi perusahaan.\n- Pengelola Risiko: Mengidentifikasi dan mengelola risiko keuangan perusahaan.\n- Manajer Portofolio: Mengelola portofolio investasi untuk individu atau perusahaan.\n\nKeterampilan yang Dibutuhkan:\n\nKeterampilan yang dibutuhkan untuk bekerja di bidang keuangan dan akuntansi bervariasi tergantung pada jenis pekerjaannya. Namun, beberapa keterampilan umum yang dibutuhkan di antaranya:\n\n- Keterampilan analitis: Mampu menganalisis data keuangan dan membuat keputusan berdasarkan analisis tersebut.\n- Keterampilan matematika: Mampu melakukan perhitungan yang tepat dan akurat.\n- Keterampilan komunikasi: Mampu berkomunikasi secara efektif dengan klien dan rekan kerja.\n- Keterampilan komputer: Mampu menggunakan perangkat lunak akuntansi dan analisis keuangan.\n- Keterampilan manajemen waktu: Mampu mengelola waktu dan prioritas dengan efektif.\n- Keterampilan pemecahan masalah: Mampu memecahkan masalah keuangan secara kreatif dan efektif.\n\nPendidikan dan Pelatihan:\n\nUntuk bekerja di bidang keuangan dan akuntansi, Anda biasanya membutuhkan pendidikan minimal sarjana di bidang keuangan, akuntansi, atau bidang terkait. Sertifikasi tambahan seperti CPA (Certified Public Accountant) atau CFA (Chartered Financial Analyst) juga sangat dihargai.\n\nGaji:\n\nGaji di bidang keuangan dan akuntansi bervariasi tergantung pada jenis pekerjaan, pengalaman, dan lokasi. Namun, secara umum, gaji di bidang ini cukup kompetitif. Menurut data dari https://gajimu.com/, rata-rata gaji bulanan untuk seorang akuntan di Indonesia adalah Rp 7.500.000, sedangkan rata-rata gaji bulanan untuk seorang analis keuangan adalah Rp 9.000.000.\n\nProspek Karir:\n\nProspek karir di bidang keuangan dan akuntansi umumnya baik. Permintaan untuk tenaga profesional di bidang ini terus meningkat seiring dengan berkembangnya ekonomi dan regulasi keuangan. Lulusan dengan kualifikasi dan keterampilan yang dibutuhkan akan memiliki peluang yang lebih baik untuk mendapatkan pekerjaan yang baik.\n\nTips Meniti Karir:\n\nBerikut beberapa tips untuk meniti karir di bidang keuangan dan akuntansi:\n\n- Dapatkan pendidikan yang relevan: Mengambil jurusan keuangan atau akuntansi di perguruan tinggi akan memberikan Anda pengetahuan dan keterampilan yang dibutuhkan untuk bekerja di bidang ini.\n- Membangun portofolio: Kumpulkan contoh pekerjaan Anda, seperti laporan keuangan atau analisis investasi. Portofolio Anda akan membantu Anda menunjukkan kemampuan Anda kepada calon pemberi kerja.\n- Magang: Magang adalah cara yang bagus untuk mendapatkan pengalaman kerja di bidang keuangan dan akuntansi. Anda dapat mencari magang di perusahaan keuangan, firma akuntansi, atau departemen keuangan perusahaan.\n- Membangun jaringan: Hadiri acara industri dan konferensi untuk bertemu dengan orang-orang yang bekerja di bidang keuangan dan akuntansi. Jaringan Anda dapat membantu Anda mendapatkan pekerjaan atau peluang lainnya.\n- Tetap up-to-date: Bidang keuangan dan akuntansi terus berkembang. Penting untuk mengikuti tren terbaru dan mengembangkan keterampilan baru untuk tetap kompetitif.";
        return createScene("Karir di Bidang Keuangan dan Akuntansi", textContent, "/image/Keuangan.png");
    }
}