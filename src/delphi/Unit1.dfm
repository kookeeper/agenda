object Form1: TForm1
  Left = 411
  Top = 150
  Width = 784
  Height = 524
  Caption = 'Form1'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -16
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 20
  object RzPageControl1: TRzPageControl
    Left = 0
    Top = 0
    Width = 768
    Height = 486
    ActivePage = tabDia
    Align = alClient
    TabIndex = 1
    TabOrder = 0
    FixedDimension = 26
    object TabSheet1: TRzTabSheet
      Caption = 'Novo Compromisso'
      DesignSize = (
        764
        456)
      object Label1: TLabel
        Left = 8
        Top = 16
        Width = 62
        Height = 20
        Caption = 'Paciente'
      end
      object Label2: TLabel
        Left = 8
        Top = 48
        Width = 35
        Height = 20
        Caption = 'Data'
      end
      object Label3: TLabel
        Left = 8
        Top = 80
        Width = 35
        Height = 20
        Caption = 'Hora'
      end
      object Label4: TLabel
        Left = 8
        Top = 112
        Width = 54
        Height = 20
        Caption = 'Per'#237'odo'
      end
      object Label5: TLabel
        Left = 8
        Top = 144
        Width = 71
        Height = 20
        Caption = 'Descri'#231#227'o'
      end
      object RzDateTimeEdit1: TRzDateTimeEdit
        Left = 64
        Top = 48
        Width = 121
        Height = 28
        EditType = etDate
        FlatButtons = True
        FrameHotTrack = True
        FrameVisible = True
        TabOrder = 0
      end
      object RzDateTimeEdit2: TRzDateTimeEdit
        Left = 64
        Top = 80
        Width = 121
        Height = 28
        EditType = etTime
        FlatButtons = True
        FrameHotTrack = True
        FrameVisible = True
        TabOrder = 1
      end
      object RzComboBox1: TRzComboBox
        Left = 64
        Top = 16
        Width = 537
        Height = 28
        Style = csDropDownList
        Ctl3D = False
        FlatButtons = True
        FrameHotTrack = True
        FrameVisible = True
        ItemHeight = 20
        ParentCtl3D = False
        TabOrder = 2
      end
      object RzDateTimeEdit3: TRzDateTimeEdit
        Left = 64
        Top = 112
        Width = 121
        Height = 28
        EditType = etTime
        FlatButtons = True
        FrameHotTrack = True
        FrameVisible = True
        TabOrder = 3
      end
      object RzEdit1: TRzEdit
        Left = 64
        Top = 144
        Width = 345
        Height = 28
        FrameHotTrack = True
        FrameVisible = True
        TabOrder = 4
      end
      object RzBitBtn1: TRzBitBtn
        Left = 608
        Top = 16
        Width = 65
        Caption = 'Novo'
        TabOrder = 5
        Glyph.Data = {
          76010000424D7601000000000000760000002800000020000000100000000100
          04000000000000010000130B0000130B00001000000000000000000000000000
          800000800000008080008000000080008000808000007F7F7F00BFBFBF000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF0033333333B333
          333B33FF33337F3333F73BB3777BB7777BB3377FFFF77FFFF77333B000000000
          0B3333777777777777333330FFFFFFFF07333337F33333337F333330FFFFFFFF
          07333337F33333337F333330FFFFFFFF07333337F33333337F333330FFFFFFFF
          07333FF7F33333337FFFBBB0FFFFFFFF0BB37777F3333333777F3BB0FFFFFFFF
          0BBB3777F3333FFF77773330FFFF000003333337F333777773333330FFFF0FF0
          33333337F3337F37F3333330FFFF0F0B33333337F3337F77FF333330FFFF003B
          B3333337FFFF77377FF333B000000333BB33337777777F3377FF3BB3333BB333
          3BB33773333773333773B333333B3333333B7333333733333337}
        NumGlyphs = 2
      end
      object RzBitBtn2: TRzBitBtn
        Left = 584
        Top = 421
        Anchors = [akRight, akBottom]
        Caption = 'Salvar'
        TabOrder = 6
        Glyph.Data = {
          76010000424D7601000000000000760000002800000020000000100000000100
          04000000000000010000120B0000120B00001000000000000000000000000000
          800000800000008080008000000080008000808000007F7F7F00BFBFBF000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00555555555555
          555555555555555555555555555555555555555555FF55555555555559055555
          55555555577FF5555555555599905555555555557777F5555555555599905555
          555555557777FF5555555559999905555555555777777F555555559999990555
          5555557777777FF5555557990599905555555777757777F55555790555599055
          55557775555777FF5555555555599905555555555557777F5555555555559905
          555555555555777FF5555555555559905555555555555777FF55555555555579
          05555555555555777FF5555555555557905555555555555777FF555555555555
          5990555555555555577755555555555555555555555555555555}
        NumGlyphs = 2
      end
      object RzBitBtn3: TRzBitBtn
        Left = 672
        Top = 421
        Anchors = [akRight, akBottom]
        Caption = 'Cancelar'
        TabOrder = 7
        Glyph.Data = {
          76010000424D7601000000000000760000002800000020000000100000000100
          04000000000000010000130B0000130B00001000000000000000000000000000
          800000800000008080008000000080008000808000007F7F7F00BFBFBF000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00333333333333
          3333333333FFFFF3333333333999993333333333F77777FFF333333999999999
          3333333777333777FF3333993333339993333377FF3333377FF3399993333339
          993337777FF3333377F3393999333333993337F777FF333337FF993399933333
          399377F3777FF333377F993339993333399377F33777FF33377F993333999333
          399377F333777FF3377F993333399933399377F3333777FF377F993333339993
          399377FF3333777FF7733993333339993933373FF3333777F7F3399933333399
          99333773FF3333777733339993333339933333773FFFFFF77333333999999999
          3333333777333777333333333999993333333333377777333333}
        NumGlyphs = 2
      end
    end
    object tabDia: TRzTabSheet
      Caption = 'Agenda de hoje'
      object DBPlanner1: TDBPlanner
        Left = 0
        Top = 0
        Width = 764
        Height = 415
        Align = alClient
        AttachementGlyph.Data = {
          F6000000424DF600000000000000760000002800000010000000100000000100
          0400000000008000000000000000000000001000000000000000000000000000
          8000008000000080800080000000800080008080000080808000C0C0C0000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00888888888888
          8888888888700078888888888708880788888888808808808888888880808080
          8888888880808080888888888080808088888888808080808888888880808080
          8888888880808080888888888080808088888888808080808888888888808080
          8888888888808880888888888888000888888888888888888888}
        Caption.Title = 'TMS software <b>TDBPlanner</b>'
        Caption.Font.Charset = DEFAULT_CHARSET
        Caption.Font.Color = clBlack
        Caption.Font.Height = -13
        Caption.Font.Name = 'Verdana'
        Caption.Font.Style = []
        Caption.Background = 16575452
        Caption.BackgroundTo = 16571329
        DayNames.Strings = (
          'Sun'
          'Mon'
          'Tue'
          'Wed'
          'Thu'
          'Fri'
          'Sat')
        DefaultItem.CaptionBkg = 16109705
        DefaultItem.CaptionBkgTo = 16109705
        DefaultItem.CaptionFont.Charset = DEFAULT_CHARSET
        DefaultItem.CaptionFont.Color = clWindowText
        DefaultItem.CaptionFont.Height = -11
        DefaultItem.CaptionFont.Name = 'MS Sans Serif'
        DefaultItem.CaptionFont.Style = []
        DefaultItem.ColorTo = clWhite
        DefaultItem.Cursor = -1
        DefaultItem.Editor = SimpleItemEditor1
        DefaultItem.Font.Charset = DEFAULT_CHARSET
        DefaultItem.Font.Color = clWindowText
        DefaultItem.Font.Height = -11
        DefaultItem.Font.Name = 'MS Sans Serif'
        DefaultItem.Font.Style = []
        DefaultItem.ItemBegin = 16
        DefaultItem.ItemEnd = 17
        DefaultItem.ItemPos = 0
        DefaultItem.Name = 'PlannerItem0'
        DefaultItem.SelectColor = 16571329
        DefaultItem.SelectColorTo = 16575452
        DefaultItem.Shadow = True
        DefaultItem.TrackColor = 16571329
        DefaultItem.TrackSelectColor = 11369558
        DeleteGlyph.Data = {
          36050000424D3605000000000000360400002800000010000000100000000100
          0800000000000001000000000000000000000001000000000000000000000000
          80000080000000808000800000008000800080800000C0C0C000C0DCC000F0CA
          A6000020400000206000002080000020A0000020C0000020E000004000000040
          20000040400000406000004080000040A0000040C0000040E000006000000060
          20000060400000606000006080000060A0000060C0000060E000008000000080
          20000080400000806000008080000080A0000080C0000080E00000A0000000A0
          200000A0400000A0600000A0800000A0A00000A0C00000A0E00000C0000000C0
          200000C0400000C0600000C0800000C0A00000C0C00000C0E00000E0000000E0
          200000E0400000E0600000E0800000E0A00000E0C00000E0E000400000004000
          20004000400040006000400080004000A0004000C0004000E000402000004020
          20004020400040206000402080004020A0004020C0004020E000404000004040
          20004040400040406000404080004040A0004040C0004040E000406000004060
          20004060400040606000406080004060A0004060C0004060E000408000004080
          20004080400040806000408080004080A0004080C0004080E00040A0000040A0
          200040A0400040A0600040A0800040A0A00040A0C00040A0E00040C0000040C0
          200040C0400040C0600040C0800040C0A00040C0C00040C0E00040E0000040E0
          200040E0400040E0600040E0800040E0A00040E0C00040E0E000800000008000
          20008000400080006000800080008000A0008000C0008000E000802000008020
          20008020400080206000802080008020A0008020C0008020E000804000008040
          20008040400080406000804080008040A0008040C0008040E000806000008060
          20008060400080606000806080008060A0008060C0008060E000808000008080
          20008080400080806000808080008080A0008080C0008080E00080A0000080A0
          200080A0400080A0600080A0800080A0A00080A0C00080A0E00080C0000080C0
          200080C0400080C0600080C0800080C0A00080C0C00080C0E00080E0000080E0
          200080E0400080E0600080E0800080E0A00080E0C00080E0E000C0000000C000
          2000C0004000C0006000C0008000C000A000C000C000C000E000C0200000C020
          2000C0204000C0206000C0208000C020A000C020C000C020E000C0400000C040
          2000C0404000C0406000C0408000C040A000C040C000C040E000C0600000C060
          2000C0604000C0606000C0608000C060A000C060C000C060E000C0800000C080
          2000C0804000C0806000C0808000C080A000C080C000C080E000C0A00000C0A0
          2000C0A04000C0A06000C0A08000C0A0A000C0A0C000C0A0E000C0C00000C0C0
          2000C0C04000C0C06000C0C08000C0C0A000F0FBFF00A4A0A000808080000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00D9ED07070707
          0707070707070707ECD9EC5E5E5E5E5E5E5E5E5E5E5E5E5E5DED070D0E161616
          161616160E0E0E0E5E07070D161656561616161616160E0E5E07070D16AF075E
          56561657B7EF0E0E5E07070D56AFF6075F565FAFF6AF160E5E07070D565EAFF6
          075FEFF6AF17160E5E07070D5E5E5EAFF607F6AF161616165E07070D5E5E5E5E
          EFF60756161616165E07070D5E5E5FEFF6EFF6075E1616165E07070D5F5F07F6
          EF5EAFF6075616165E07070D6707F6075E5656AFF60716165E07070DA7AF075F
          5E5E5E5EAFAF56165E07070DA7A7675F5F5E5E5E5E5E56165E07EDAF0D0D0D0D
          0D0D0D0D0D0D0D0D5EECD9ED070707070707070707070707EDD1}
        Display.ActiveEnd = 40
        Display.ColorActive = 16575452
        Display.ColorNonActive = clWhite
        Display.HourLineColor = 13542013
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        Footer.Captions.Strings = (
          ''
          '')
        Footer.CompletionFormat = '%d%%'
        Footer.Color = 16645114
        Footer.ColorTo = 16643051
        Footer.Completion.Font.Charset = DEFAULT_CHARSET
        Footer.Completion.Font.Color = clWindowText
        Footer.Completion.Font.Height = -11
        Footer.Completion.Font.Name = 'Arial'
        Footer.Completion.Font.Style = []
        Footer.Font.Charset = DEFAULT_CHARSET
        Footer.Font.Color = clWindowText
        Footer.Font.Height = -11
        Footer.Font.Name = 'MS Sans Serif'
        Footer.Font.Style = []
        GridLeftCol = 0
        GridLineColor = 16504504
        GridTopRow = 1
        Header.ActiveColor = 16575452
        Header.ActiveColorTo = 16571329
        Header.Captions.Strings = (
          ''
          '')
        Header.Color = 16645114
        Header.ColorTo = 16643051
        Header.CustomGroups = <>
        Header.Font.Charset = DEFAULT_CHARSET
        Header.Font.Color = clBlack
        Header.Font.Height = -11
        Header.Font.Name = 'MS Sans Serif'
        Header.Font.Style = []
        Header.GroupHeight = 0
        Header.GroupFont.Charset = DEFAULT_CHARSET
        Header.GroupFont.Color = clWindowText
        Header.GroupFont.Height = -11
        Header.GroupFont.Name = 'MS Sans Serif'
        Header.GroupFont.Style = []
        HintPause = 2500
        HTMLOptions.CellFontStyle = []
        HTMLOptions.HeaderFontStyle = []
        HTMLOptions.SidebarFontStyle = []
        Items = <>
        Mode.Month = 7
        Mode.PeriodStartDay = 10
        Mode.PeriodStartMonth = 7
        Mode.PeriodStartYear = 2013
        Mode.PeriodEndDay = 10
        Mode.PeriodEndMonth = 8
        Mode.PeriodEndYear = 2013
        Mode.TimeLineStart = 41465.000000000000000000
        Mode.TimeLineNVUBegin = 0
        Mode.TimeLineNVUEnd = 0
        Mode.Year = 2013
        Mode.Day = 10
        Sidebar.ActiveColor = 16575452
        Sidebar.ActiveColorTo = 16571329
        Sidebar.Background = 16645114
        Sidebar.BackgroundTo = 16643051
        Sidebar.Font.Charset = DEFAULT_CHARSET
        Sidebar.Font.Color = clBlack
        Sidebar.Font.Height = -11
        Sidebar.Font.Name = 'Arial'
        Sidebar.Font.Style = []
        Sidebar.HourFontRatio = 1.800000000000000000
        Sidebar.LineColor = 13542013
        Sidebar.Occupied = clWhite
        Sidebar.OccupiedTo = clWhite
        Sidebar.Position = spTop
        Sidebar.SeparatorLineColor = 13542013
        Positions = 1
        PositionProps = <>
        PrintOptions.LineWidth = 0
        PrintOptions.FooterFont.Charset = DEFAULT_CHARSET
        PrintOptions.FooterFont.Color = clWindowText
        PrintOptions.FooterFont.Height = -11
        PrintOptions.FooterFont.Name = 'MS Sans Serif'
        PrintOptions.FooterFont.Style = []
        PrintOptions.HeaderFont.Charset = DEFAULT_CHARSET
        PrintOptions.HeaderFont.Color = clWindowText
        PrintOptions.HeaderFont.Height = -11
        PrintOptions.HeaderFont.Name = 'MS Sans Serif'
        PrintOptions.HeaderFont.Style = []
        SelectColor = 16109705
        TrackColor = 16571329
        URLGlyph.Data = {
          F6000000424DF600000000000000760000002800000010000000100000000100
          0400000000008000000000000000000000001000000000000000000000000000
          8000008000000080800080000000800080008080000080808000C0C0C0000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00888880000800
          0088888808F8F0F8F80888808000000000808880F070888070F0888080000000
          0080880408F8F0F8F80880CCC0000400008874CCC2222C4788887CCCC22226C0
          88887CC822222CC088887C822224642088887C888422C220888877CF8CCCC227
          888887F8F8222208888888776888208888888887777778888888}
        Version = '3.0.3.0'
        ItemSource = DBDaySource1
      end
      object RzPanel1: TRzPanel
        Left = 0
        Top = 415
        Width = 764
        Height = 41
        Align = alBottom
        TabOrder = 1
        DesignSize = (
          762
          39)
        object RzBitBtn4: TRzBitBtn
          Left = 571
          Top = 6
          Width = 188
          Anchors = [akTop, akRight]
          Caption = 'Incluir compromisso'
          TabOrder = 0
          OnClick = RzBitBtn4Click
          Glyph.Data = {
            76010000424D7601000000000000760000002800000020000000100000000100
            04000000000000010000130B0000130B00001000000000000000000000000000
            800000800000008080008000000080008000808000007F7F7F00BFBFBF000000
            FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF0033333333B333
            333B33FF33337F3333F73BB3777BB7777BB3377FFFF77FFFF77333B000000000
            0B3333777777777777333330FFFFFFFF07333337F33333337F333330FFFFFFFF
            07333337F33333337F333330FFFFFFFF07333337F33333337F333330FFFFFFFF
            07333FF7F33333337FFFBBB0FFFFFFFF0BB37777F3333333777F3BB0FFFFFFFF
            0BBB3777F3333FFF77773330FFFF000003333337F333777773333330FFFF0FF0
            33333337F3337F37F3333330FFFF0F0B33333337F3337F77FF333330FFFF003B
            B3333337FFFF77377FF333B000000333BB33337777777F3377FF3BB3333BB333
            3BB33773333773333773B333333B3333333B7333333733333337}
          NumGlyphs = 2
        end
      end
    end
    object tabMes: TRzTabSheet
      Caption = 'Este mes'
      object DBPlannerMonthView1: TDBPlannerMonthView
        Left = 0
        Top = 0
        Width = 764
        Height = 415
        Cursor = crDefault
        Align = alClient
        AttachementGlyph.Data = {
          F6000000424DF600000000000000760000002800000010000000100000000100
          0400000000008000000000000000000000001000000000000000000000000000
          8000008000000080800080000000800080008080000080808000C0C0C0000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00888888888888
          8888888888700078888888888708880788888888808808808888888880808080
          8888888880808080888888888080808088888888808080808888888880808080
          8888888880808080888888888080808088888888808080808888888888808080
          8888888888808880888888888888000888888888888888888888}
        BevelOuter = bvNone
        BorderWidth = 1
        CaptionColor = 16575452
        CaptionColorTo = 16571329
        CaptionFont.Charset = DEFAULT_CHARSET
        CaptionFont.Color = clBlack
        CaptionFont.Height = -11
        CaptionFont.Name = 'MS Sans Serif'
        CaptionFont.Style = []
        Color = clWhite
        Completion.Font.Charset = DEFAULT_CHARSET
        Completion.Font.Color = clWindowText
        Completion.Font.Height = -11
        Completion.Font.Name = 'Arial'
        Completion.Font.Style = []
        DateFormat = 'dd/mm/yyyy'
        DayFont.Charset = DEFAULT_CHARSET
        DayFont.Color = clBlack
        DayFont.Height = -11
        DayFont.Name = 'MS Sans Serif'
        DayFont.Style = []
        DefaultItem.CaptionBkg = 16109705
        DefaultItem.CaptionBkgTo = 16109705
        DefaultItem.CaptionFont.Charset = DEFAULT_CHARSET
        DefaultItem.CaptionFont.Color = clWindowText
        DefaultItem.CaptionFont.Height = -11
        DefaultItem.CaptionFont.Name = 'MS Sans Serif'
        DefaultItem.CaptionFont.Style = []
        DefaultItem.ColorTo = clWhite
        DefaultItem.Cursor = -1
        DefaultItem.Editor = SimpleItemEditor1
        DefaultItem.Font.Charset = DEFAULT_CHARSET
        DefaultItem.Font.Color = clWindowText
        DefaultItem.Font.Height = -11
        DefaultItem.Font.Name = 'MS Sans Serif'
        DefaultItem.Font.Style = []
        DefaultItem.ItemBegin = 16
        DefaultItem.ItemEnd = 17
        DefaultItem.ItemPos = 0
        DefaultItem.Name = 'PlannerItem0'
        DefaultItem.SelectColor = 16571329
        DefaultItem.SelectColorTo = 16575452
        DefaultItem.Shadow = True
        DefaultItem.TrackColor = 16571329
        DefaultItem.TrackSelectColor = 11369558
        DeleteGlyph.Data = {
          36050000424D3605000000000000360400002800000010000000100000000100
          0800000000000001000000000000000000000001000000000000000000000000
          80000080000000808000800000008000800080800000C0C0C000C0DCC000F0CA
          A6000020400000206000002080000020A0000020C0000020E000004000000040
          20000040400000406000004080000040A0000040C0000040E000006000000060
          20000060400000606000006080000060A0000060C0000060E000008000000080
          20000080400000806000008080000080A0000080C0000080E00000A0000000A0
          200000A0400000A0600000A0800000A0A00000A0C00000A0E00000C0000000C0
          200000C0400000C0600000C0800000C0A00000C0C00000C0E00000E0000000E0
          200000E0400000E0600000E0800000E0A00000E0C00000E0E000400000004000
          20004000400040006000400080004000A0004000C0004000E000402000004020
          20004020400040206000402080004020A0004020C0004020E000404000004040
          20004040400040406000404080004040A0004040C0004040E000406000004060
          20004060400040606000406080004060A0004060C0004060E000408000004080
          20004080400040806000408080004080A0004080C0004080E00040A0000040A0
          200040A0400040A0600040A0800040A0A00040A0C00040A0E00040C0000040C0
          200040C0400040C0600040C0800040C0A00040C0C00040C0E00040E0000040E0
          200040E0400040E0600040E0800040E0A00040E0C00040E0E000800000008000
          20008000400080006000800080008000A0008000C0008000E000802000008020
          20008020400080206000802080008020A0008020C0008020E000804000008040
          20008040400080406000804080008040A0008040C0008040E000806000008060
          20008060400080606000806080008060A0008060C0008060E000808000008080
          20008080400080806000808080008080A0008080C0008080E00080A0000080A0
          200080A0400080A0600080A0800080A0A00080A0C00080A0E00080C0000080C0
          200080C0400080C0600080C0800080C0A00080C0C00080C0E00080E0000080E0
          200080E0400080E0600080E0800080E0A00080E0C00080E0E000C0000000C000
          2000C0004000C0006000C0008000C000A000C000C000C000E000C0200000C020
          2000C0204000C0206000C0208000C020A000C020C000C020E000C0400000C040
          2000C0404000C0406000C0408000C040A000C040C000C040E000C0600000C060
          2000C0604000C0606000C0608000C060A000C060C000C060E000C0800000C080
          2000C0804000C0806000C0808000C080A000C080C000C080E000C0A00000C0A0
          2000C0A04000C0A06000C0A08000C0A0A000C0A0C000C0A0E000C0C00000C0C0
          2000C0C04000C0C06000C0C08000C0C0A000F0FBFF00A4A0A000808080000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00D9ED07070707
          0707070707070707ECD9EC5E5E5E5E5E5E5E5E5E5E5E5E5E5DED070D0E161616
          161616160E0E0E0E5E07070D161656561616161616160E0E5E07070D16AF075E
          56561657B7EF0E0E5E07070D56AFF6075F565FAFF6AF160E5E07070D565EAFF6
          075FEFF6AF17160E5E07070D5E5E5EAFF607F6AF161616165E07070D5E5E5E5E
          EFF60756161616165E07070D5E5E5FEFF6EFF6075E1616165E07070D5F5F07F6
          EF5EAFF6075616165E07070D6707F6075E5656AFF60716165E07070DA7AF075F
          5E5E5E5EAFAF56165E07070DA7A7675F5F5E5E5E5E5E56165E07EDAF0D0D0D0D
          0D0D0D0D0D0D0D0D5EECD9ED070707070707070707070707EDD1}
        FocusColor = 16109705
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        GradientStartColor = clNone
        HintPrevYear = 'Previous Year'
        HintPrevMonth = 'Previous Month'
        HintNextMonth = 'Next Month'
        HintNextYear = 'Next Year'
        InActiveColor = clWhite
        InversColor = clGray
        InversBkColor = 16575452
        Items = <>
        LineColor = 13542013
        Line3D = False
        MonthGradientStartColor = clWhite
        MonthGradientEndColor = clWhite
        NameOfDays.Monday = 'seg'
        NameOfDays.Tuesday = 'ter'
        NameOfDays.Wednesday = 'qua'
        NameOfDays.Thursday = 'qui'
        NameOfDays.Friday = 'sex'
        NameOfDays.Saturday = 's'#225'b'
        NameOfDays.Sunday = 'dom'
        NameOfDays.UseIntlNames = True
        NameOfMonths.January = 'jan'
        NameOfMonths.February = 'fev'
        NameOfMonths.March = 'mar'
        NameOfMonths.April = 'abr'
        NameOfMonths.May = 'mai'
        NameOfMonths.June = 'jun'
        NameOfMonths.July = 'jul'
        NameOfMonths.August = 'ago'
        NameOfMonths.September = 'set'
        NameOfMonths.October = 'out'
        NameOfMonths.November = 'nov'
        NameOfMonths.December = 'dez'
        NameOfMonths.UseIntlNames = True
        PrintOptions.FooterFont.Charset = DEFAULT_CHARSET
        PrintOptions.FooterFont.Color = clWindowText
        PrintOptions.FooterFont.Height = -11
        PrintOptions.FooterFont.Name = 'MS Sans Serif'
        PrintOptions.FooterFont.Style = []
        PrintOptions.HeaderFont.Charset = DEFAULT_CHARSET
        PrintOptions.HeaderFont.Color = clWindowText
        PrintOptions.HeaderFont.Height = -11
        PrintOptions.HeaderFont.Name = 'MS Sans Serif'
        PrintOptions.HeaderFont.Style = []
        SelectColor = 16109705
        SelectFontColor = clBlack
        TabOrder = 0
        TodayColor = 16575452
        TodayColorTo = 16571329
        URLGlyph.Data = {
          F6000000424DF600000000000000760000002800000010000000100000000100
          0400000000008000000000000000000000001000000000000000000000000000
          8000008000000080800080000000800080008080000080808000C0C0C0000000
          FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00888880000800
          0088888808F8F0F8F80888808000000000808880F070888070F0888080000000
          0080880408F8F0F8F80880CCC0000400008874CCC2222C4788887CCCC22226C0
          88887CC822222CC088887C822224642088887C888422C220888877CF8CCCC227
          888887F8F8222208888888776888208888888887777778888888}
        WeekFont.Charset = DEFAULT_CHARSET
        WeekFont.Color = clWindowText
        WeekFont.Height = -11
        WeekFont.Name = 'MS Sans Serif'
        WeekFont.Style = []
        WeekName = 'Wk'
        WeekendTextColor = 13542013
        Day = 10
        Month = 7
        Year = 2013
        Version = '3.0.2.0'
        DataSource = DataSource1
      end
      object RzPanel2: TRzPanel
        Left = 0
        Top = 415
        Width = 764
        Height = 41
        Align = alBottom
        TabOrder = 1
        DesignSize = (
          762
          39)
        object RzBitBtn5: TRzBitBtn
          Left = 606
          Top = 6
          Width = 151
          Anchors = [akTop, akRight]
          Caption = 'Visualizar Dia'
          TabOrder = 0
          OnClick = RzBitBtn5Click
          Glyph.Data = {
            76010000424D7601000000000000760000002800000020000000100000000100
            04000000000000010000120B0000120B00001000000000000000000000000000
            800000800000008080008000000080008000808000007F7F7F00BFBFBF000000
            FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00333333333333
            333333333333FF3333333333333C0C333333333333F777F3333333333CC0F0C3
            333333333777377F33333333C30F0F0C333333337F737377F333333C00FFF0F0
            C33333F7773337377F333CC0FFFFFF0F0C3337773F33337377F3C30F0FFFFFF0
            F0C37F7373F33337377F00FFF0FFFFFF0F0C7733373F333373770FFFFF0FFFFF
            F0F073F33373F333373730FFFFF0FFFFFF03373F33373F333F73330FFFFF0FFF
            00333373F33373FF77333330FFFFF000333333373F333777333333330FFF0333
            3333333373FF7333333333333000333333333333377733333333333333333333
            3333333333333333333333333333333333333333333333333333}
          NumGlyphs = 2
        end
      end
    end
  end
  object SimpleItemEditor1: TSimpleItemEditor
    EditorUse = euAlways
    OnBeforeEditShow = DefaultItemEditor1BeforeEditShow
    FormLeft = 0
    FormTop = 0
    LblWarning = 'Aten'#231#227'o: Este compromisso ocorrer'#225' no passado'
    LblSubject = '&Descri'#231#227'o'
    LblDate = '&Data'
    LblFrom = '&De'
    LblTo = '&At'#233
    LblColor = '&Cor'
    LblShape = '&Formato'
    LblNotes = '&Notas'
    ShowShape = False
    Left = 217
    Top = 124
  end
  object DBMonthSource1: TDBMonthSource
    AutoIncKey = False
    DataSource = DataSource1
    ResourceMap = <>
    ReadOnly = False
    UpdateByQuery = False
    Month = 7
    Year = 2013
    Left = 345
    Top = 163
  end
  object DataSource1: TDataSource
    Left = 225
    Top = 275
  end
  object DBDaySource1: TDBDaySource
    AutoIncKey = False
    DataSource = DataSource1
    ResourceMap = <>
    ReadOnly = False
    UpdateByQuery = False
    DateFormat = 'mm/dd/yyyy'
    Mode = dmMultiDay
    Left = 353
    Top = 259
  end
end
